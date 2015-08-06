package s99

import org.scalatest.{FunSpec, Matchers}

class P13Spec extends FunSpec with Matchers {

  describe("encodeDirect") {
    it("(**) Run-length encoding of a list (direct solution).") {
      // Implement the so-called run-length encoding data compression method directly.
      // I.e. don't use other methods you've written (like P09's pack); do all the work directly.
      val list = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
      val expected = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))
      P13.encodeDirect(list) should equal (expected)
      P13.encodeDirect(List.empty) should equal (List.empty)
    }
  }

  describe("encodeDirectRec") {
    it("(**) Run-length encoding of a list (direct solution).") {
      // Implement the so-called run-length encoding data compression method directly.
      // I.e. don't use other methods you've written (like P09's pack); do all the work directly.
      val list = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
      val expected = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))
      P13.encodeDirectRec(list) should equal (expected)
      P13.encodeDirectRec(List.empty) should equal (List.empty)
    }
  }

}
