package s99

import org.scalatest.{FunSpec, Matchers}

class P04Spec extends FunSpec with Matchers {

  describe("length(List)") {
    it("(*) Find the number of elements of a list.") {
      (0 to 9).foreach { n =>
        val l = List.fill(n)(0)
        P04.length(l) should === (n)
      }
    }
  }

  describe("length2(List)") {
    it("(*) Find the number of elements of a list.") {
      (0 to 9).foreach { n =>
        val l = List.fill(n)(0)
        P04.length2(l) should === (n)
      }
    }
  }

}
