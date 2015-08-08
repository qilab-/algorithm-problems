package s99

import org.scalatest.{FunSpec, Matchers}

class P14Spec extends FunSpec with Matchers {

  describe("duplicate") {
    it("(*) Duplicate the elements of a list.") {
      val list = List('a, 'b, 'c, 'c, 'd)
      val expected = List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)
      P14.duplicate(list) should equal (expected)
      P14.duplicate(List.empty) should equal (List.empty)
    }
  }

  describe("duplicateRec") {
    it("(*) Duplicate the elements of a list.") {
      val list = List('a, 'b, 'c, 'c, 'd)
      val expected = List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)
      P14.duplicateRec(list) should equal (expected)
      P14.duplicateRec(List.empty) should equal (List.empty)
    }
  }

}
