package la.aquare.aula3.akka
import akka.actor.Actor
import akka.event.Logging
import akka.actor.Props

class Supervisor extends Actor {
  val log = Logging(context.system, this)
  var respostas: List[Dados.Resposta] = Nil
  def receive = {
    case Controle.Processar =>
      for (i <- 1 to 3) {
        var c = context.actorOf(Props[Worker], "c" + i)
        c ! Dados.Requisicao("data" + i + ".csv")
      }
    case dados: Dados.Resposta => {
      log.info("resposta recebida: " + dados)
      respostas = respostas :+ dados
      if (respostas.size == 3) {
        val contagem = respostas.map { r => r.contagem }.reduce(_ + _)
        val total = respostas.map { r => r.total }.reduce(_ + _)
        val media = total / contagem
        context.parent ! Controle.Finalizar(media)
      }
    }
  }
}

class Worker extends Actor {
  val log = Logging(context.system, this)
  def receive = {
    case dados: Dados.Requisicao =>
      val arq = io.Source.fromFile(dados.file).getLines().toList
      val plain = arq.map { l => l.split(';') }.flatten
      val total = plain.map { x => x.toInt }.sum
      log.info("total do arquivo: " + total.toString)
      context.parent ! Dados.Resposta(total, plain.size)
  }
}