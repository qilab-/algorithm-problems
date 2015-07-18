package s99

import org.scalatest.{FunSpec, Matchers}

class P01Spec extends FunSpec with Matchers {

  describe("last(List)") {
    it("(*) Find the last element of a list.") {
      P01.last(List(1, 1, 2, 3, 5, 8)) should === (8)
      P01.last(List("a", "a", "b", "c", "e", "h")) should === ("h")
    }

    it("throws NoSuchElementException if the list is empty.") {
      intercept[NoSuchElementException](P01.last(List.empty[Int]))
    }
  }

  describe("lastRec(List)") {
    it("(*) Find the last element of a list.") {
      P01.lastRec(List(1, 1, 2, 3, 5, 8)) should === (8)
      P01.lastRec(List("a", "a", "b", "c", "e", "h")) should === ("h")
    }

    it("throws NoSuchElementException if the list is empty.") {
      intercept[NoSuchElementException](P01.lastRec(List.empty[Int]))
    }
  }

}
