package s99

import org.scalatest.{FunSpec, Matchers}

class P07Spec extends FunSpec with Matchers {

  describe("flatten(List)") {
    it("(**) Flatten a nested list structure.") {
      P07.flatten(List(List(1, 1), 2, List(3, List(5, 8)))) should equal (List(1, 1, 2, 3, 5, 8))
      P07.flatten(List.empty) should equal (List.empty)
    }
  }

  describe("flatten2(List)") {
    it("(**) Flatten a nested list structure.") {
      P07.flatten2(List(List(1, 1), 2, List(3, List(5, 8)))) should equal (List(1, 1, 2, 3, 5, 8))
      P07.flatten2(List.empty) should equal (List.empty)
    }
  }

}
