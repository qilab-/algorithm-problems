package s99

import org.scalatest.{FunSpec, Matchers}

class P05Spec extends FunSpec with Matchers {

  describe("reverse(List)") {
    it("(*) Reverse a list.") {
      P05.reverse(List.empty[Int]) should === (List.empty[Int])
      P05.reverse(List(1, 1, 2, 3, 5, 8)) should === (List(8, 5, 3, 2, 1, 1))

      (0 to 9).foreach { n =>
        val l = List((1 to n): _*)
        P05.reverse(l) should === (l.reverse)
      }
    }
  }

  describe("reverse2(List)") {
    it("(*) Reverse a list.") {
      P05.reverse2(List.empty[Int]) should === (List.empty[Int])
      P05.reverse2(List(1, 1, 2, 3, 5, 8)) should === (List(8, 5, 3, 2, 1, 1))

      (0 to 9).foreach { n =>
        val l = List((1 to n): _*)
        P05.reverse2(l) should === (l.reverse)
      }
    }
  }

}
