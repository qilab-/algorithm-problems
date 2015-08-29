package s99

import org.scalatest.{FunSpec, Matchers}

class P17Spec extends FunSpec with Matchers {

  describe("drop") {
    it("(*) Split a list into two parts.") {
      val list = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
      val expected = (List('a, 'b, 'c), List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
      P17.split(3, list) should equal (expected)
      P17.split(3, List.empty) should equal (List.empty, List.empty)
    }
  }

  describe("dropRec") {
    it("(*) Split a list into two parts.") {
      val list = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
      val expected = (List('a, 'b, 'c), List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
      P17.splitRec(3, list) should equal (expected)
      P17.splitRec(3, List.empty) should equal (List.empty, List.empty)
    }
  }

}
