package la.aquare.aula3.akka
import akka.actor.Actor
import akka.actor.Props
import akka.event.Logging

object Dados {
  case class Requisicao(file: String)
  case class Resposta(total: Double, contagem: Int)
}

object Controle {
  object Processar
  case class Finalizar(media: Double)
}

class Root extends Actor {
  override def preStart = {
    val sup = context.actorOf(Props[Supervisor], "sup")
    sup ! Controle.Processar
  }
  def receive = {
    case controle: Controle.Finalizar => {
    	context.stop(self)
      println("Média Final: " + controle.media)
    }
  }
}

object AkkaApp extends App {
  akka.Main.main(Array(classOf[Root].getName))
}