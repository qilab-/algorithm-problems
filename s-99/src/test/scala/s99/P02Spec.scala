package s99

import org.scalatest.{FunSpec, Matchers}

class P02Spec extends FunSpec with Matchers {

  describe("penultimate(List)") {
    it("(*) Find the last but one element of a list.") {
      P02.penultimate(List(1, 1, 2, 3, 5, 8)) should === (5)
      P02.penultimate(List("a", "a", "b", "c", "e", "h")) should === ("e")
    }

    it("throws NoSuchElementException if the size of the list is less than 2.") {
      intercept[NoSuchElementException](P02.penultimate(List.empty[Int]))
      intercept[NoSuchElementException](P02.penultimate(List(1)))
    }
  }

  describe("penultimateRec(List)") {
    it("(*) Find the last but one element of a list.") {
      P02.penultimateRec(List(1, 1, 2, 3, 5, 8)) should === (5)
      P02.penultimateRec(List("a", "a", "b", "c", "e", "h")) should === ("e")
    }

    it("throws NoSuchElementException if the size of the list is less than 2.") {
      intercept[NoSuchElementException](P02.penultimateRec(List.empty[Int]))
      intercept[NoSuchElementException](P02.penultimateRec(List(1)))
    }
  }

}
