package s99

import org.scalatest.{FunSpec, Matchers}

class P08Spec extends FunSpec with Matchers {

  describe("compress(List)") {
    it("(**) Eliminate consecutive duplicates of list elements.") {
      // If a list contains repeated elements they should be replaced with a single copy of the element.
      // The order of the elements should not be changed.
      val list = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
      val expected = List('a, 'b, 'c, 'a, 'd, 'e)
      P08.compress(list) should equal (expected)
      P08.compress(List.empty) should equal (List.empty)
    }
  }

}
