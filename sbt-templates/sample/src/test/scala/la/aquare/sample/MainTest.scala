package la.aquare.sample

import org.junit._

class MainTest {
  @Test def testHelloWorld = {
    val msg = new Main().msg
    assert(msg == "Hello world!")
  }
}