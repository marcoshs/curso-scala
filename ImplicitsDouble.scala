package la.aquare.aula2.dsl.b

object MeusOperadores {
  implicit def int2MyInt(i: Int) = new MyInt(i)
  implicit def int2MyDouble(i: Double) = new MyDouble(i)
}

class MyInt(l: Int) {
  import MeusOperadores._
  def ++(r: Double) = l + r + 1
  def ++(r: Int) = l + r + 1
}

class MyDouble(l: Double) {
  import MeusOperadores._
  def ++(r: Double) = l + r + 1.0
  def ++(r: Int) = l + r + 1.0
}

object Aula2 extends App {
  import MeusOperadores._
  println(2 ++ 4)
  println(2.1 ++ 4)
  println(2 ++ 4.1)
  println(2.1 ++ 4.1)
}