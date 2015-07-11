package la.aquare.aula2
import org.junit._

class TempOOTest {
  @Test def cToF = {
    assert(ºC(0).to(ºF) == 32.0)
    assert(ºC(50).to(ºF) == 122.0)
    assert(ºC(100).to(ºF) == 212.0)
  }

  @Test def fToC = {
    assert(ºF(212.0).to(ºC) == 100)
  }

  @Test def kTof = {
    assert(ºK(283.15).to(ºF) == 50)
    assert(ºK(10).to(ºK) == 10)
  }

  @Test def identity = {
    assert(ºK(10).to(ºK) == 10)
    assert(ºF(10).to(ºF) == 10)
    assert(ºC(10).to(ºC) == 10)
  }

}