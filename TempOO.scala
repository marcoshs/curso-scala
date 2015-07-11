package la.aquare.aula2

trait UnidadeObject { def getInstance: UnidadeClass }
trait UnidadeClass {
  val input: Double
  val gelo: Double
  val fervura: Double
  def to(unidade: UnidadeObject) = {
    val destino = unidade.getInstance
    val difOrigem = this.fervura - this.gelo
    val difDestino = destino.fervura - destino.gelo
    val proporcao = difDestino / difOrigem
    (input - this.gelo) * proporcao + destino.gelo
  }
}

object ºC extends UnidadeObject { def getInstance = new ºC }
object ºF extends UnidadeObject { def getInstance = new ºF }
object ºK extends UnidadeObject { def getInstance = new ºK }

case class ºC(input: Double = 0) extends UnidadeClass {
  val gelo = 0.0
  val fervura = 100.0
}

case class ºF(input: Double = 0) extends UnidadeClass {
  val gelo = 32.0
  val fervura = 212.0
}

case class ºK(input: Double = 0) extends UnidadeClass {
  val gelo = 273.15
  val fervura = 373.15
}

