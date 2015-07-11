package la.aquare.aula2.dsl

object MeusOperadores {
  implicit def int2MyInt(i: Int) = new MyInt(i)
}

class MyInt(l: Int) {
  import MeusOperadores._
  def ++(r: Double) = l + r + 1.0
  def ++(r: Int) = l + r + 1.0
}

object Aula2 extends App  {
  import MeusOperadores._
  println( 2 ++ 4)
}


