package s99

import org.scalatest.{FunSpec, Matchers}

class P11Spec extends FunSpec with Matchers {

  describe("encodeModified(List)") {
    it("(*) Modified run-length encoding.") {
      // Modify the result of problem P10 in such a way that if an element has no duplicates it is simply copied into the result list.
      // Only elements with duplicates are transferred as (N, E) terms.
      val list = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
      val expected = List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e))
      P11.encodeModified(list) should equal (expected)
      P11.encodeModified(List.empty) should equal (List.empty)
    }
  }

}
