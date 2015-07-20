package s99

import org.scalatest.{FunSpec, Matchers}

class P09Spec extends FunSpec with Matchers {

  describe("pack(List)") {
    it("(**) Pack consecutive duplicates of list elements into sublists.") {
      // If a list contains repeated elements they should be placed in separate sublists.
      val list = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
      val expected = List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))
      P09.pack(list) should equal (expected)
      P09.pack(List.empty[List[_]]) should equal (List.empty[List[_]])
    }
  }

}
