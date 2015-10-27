package la.aquare.sampledep
import la.aquare.sample._


class MainDep() {
  val premsg = (new Main).msg
  val msg = premsg + " From sampledep!"
}

object MainDep extends App {
  println(new MainDep().msg)
}
