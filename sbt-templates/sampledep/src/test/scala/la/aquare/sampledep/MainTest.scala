package la.aquare.sampledep

import org.junit._

class MainTest {
  @Test def testHelloWorld = {
    val msg = new MainDep().msg
    assert(msg == "Hello world! From sampledep!")
  }
}