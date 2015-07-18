package s99

import org.scalatest.{FunSpec, Matchers}

class P03Spec extends FunSpec with Matchers {

  describe("penultimate(List)") {
    it("(*) Find the Kth element of a list. By convention, the first element in the list is element 0. ") {
      val list = List(1, 1, 2, 3, 5, 8)
      list.zipWithIndex.foreach { case (elem, index) =>
        P03.nth(index, list) should === (elem)
      }
    }

    it("throws NoSuchElementException if n >= size of the list.") {
      intercept[NoSuchElementException](P03.nth(0, List.empty[Int]))
      intercept[NoSuchElementException](P03.nth(1, List(1)))
      intercept[NoSuchElementException](P03.nth(2, List(1)))
    }

    it("throws IllegalArgumentException if n < 0.") {
      intercept[IllegalArgumentException](P03.nth(-1, List(1)))
      intercept[IllegalArgumentException](P03.nth(-2, List(1)))
    }
  }

}
