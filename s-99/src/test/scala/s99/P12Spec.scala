package s99

import org.scalatest.{FunSpec, Matchers}

class P12Spec extends FunSpec with Matchers {

  describe("decode") {
    it("(**) Decode a run-length encoded list.") {
      // Given a run-length code list generated as specified in problem P10, construct its uncompressed version.
      val list = List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))
      val expected = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
      P12.decode(list) should equal (expected)
      P12.decode(List.empty) should equal (List.empty)
    }
  }

}
