package la.aquare.aula2.d
trait Pessoa {
  val nome: String
}

trait User {
  val login: String
  val level: Int = 100
}

trait Standart extends User {
  override val level = 200
}

trait Admin extends User {
  override val level = 500
  def addUser(login: String, nome: String) = {
    Database.usuarios = Database.usuarios + (login -> nome)
  }
}
class Funcionario(userlogin: String) extends Pessoa with Standart {
  val login = userlogin
  val nome = Database.usuarios(login)
}

class Gerente(userlogin: String) extends Pessoa with Admin {
  val login = userlogin
  val nome = Database.usuarios(login)
}
object Database {
  var usuarios = Map("zeca" -> "José dos Anzois", "maria" -> "Maria Madalena")
}

object app extends App {
  val f1 = new Funcionario("zeca")
  val f2 = new Gerente("maria")
  println(f1.login, f1.level)
  println(f2.login, f2.level)
  f2.addUser("manoel", "Manoel da Logoa")
  println("Database: " + Database.usuarios)
}

