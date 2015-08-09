package s99

import org.scalatest.{FunSpec, Matchers}

class P16Spec extends FunSpec with Matchers {

  describe("drop") {
    it("(**) Drop every Nth element from a list.") {
      val list = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
      val expected = List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)
      P16.drop(3, list) should equal (expected)
      P16.drop(3, List.empty) should equal (List.empty)
    }
  }

  describe("dropRec") {
    it("(**) Drop every Nth element from a list.") {
      val list = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
      val expected = List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)
      P16.dropRec(3, list) should equal (expected)
      P16.dropRec(3, List.empty) should equal (List.empty)
    }
  }

}
