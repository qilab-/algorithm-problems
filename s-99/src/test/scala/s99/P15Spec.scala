package s99

import org.scalatest.{FunSpec, Matchers}

class P15Spec extends FunSpec with Matchers {

  describe("duplicateN") {
    it("(**) Duplicate the elements of a list a given number of times.") {
      val list = List('a, 'b, 'c, 'c, 'd)
      val expected = List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd)
      P15.duplicateN(3, list) should equal (expected)
      P15.duplicateN(3, List.empty) should equal (List.empty)
    }
  }

  describe("duplicateNRec") {
    it("(**) Duplicate the elements of a list a given number of times.") {
      val list = List('a, 'b, 'c, 'c, 'd)
      val expected = List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd)
      P15.duplicateNRec(3, list) should equal (expected)
      P15.duplicateNRec(3, List.empty) should equal (List.empty)
    }
  }

}
