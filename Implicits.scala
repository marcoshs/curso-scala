package la.aquare.aula2.dsl

object VectorOperators {
  implicit def int2MyDouble(i: Int) = new MyInt(i)
}

class MyInt(l: Double) {
  import VectorOperators._
  def ++(r: Double) = l + r + 1.0
  def ++(r: Int) = l + r + 1.0
}

object Aula2 extends App  {
  import VectorOperators._
  println( 2 ++ 4)
}


