package s99

import org.scalatest.{FunSpec, Matchers}

class P10Spec extends FunSpec with Matchers {

  describe("encode(List)") {
    it("(*) Run-length encoding of a list.") {
      // Use the result of problem P09 to implement the so-called run-length encoding data compression method.
      // Consecutive duplicates of elements are encoded as tuples (N, E) where N is the number of duplicates of the element E.
      val list = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
      val expected = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))
      P10.encode(list) should equal (expected)
      P10.encode(List.empty) should equal (List.empty)
    }
  }

}
