package s99

import org.scalatest.{FunSpec, Matchers}

class P06Spec extends FunSpec with Matchers {

  describe("isPalindrome(List)") {
    it("(*) Find out whether a list is a palindrome.") {
      // false case
      P06.isPalindrome(List(1, 1, 2, 3, 5, 8)) should === (false)
      P06.isPalindrome(List(1, 2, 3, 3, 1)) should === (false)
      P06.isPalindrome(List(1, 2, 3, 4, 2, 1)) should === (false)

      // In case the number of element is odd.
      P06.isPalindrome(List(1)) should === (true)
      P06.isPalindrome(List(1, 2, 1)) should === (true)
      P06.isPalindrome(List(1, 2, 3, 2, 1)) should === (true)
      // In case the number of element is even.
      P06.isPalindrome(List.empty[Int]) should === (true)
      P06.isPalindrome(List(1, 1)) should === (true)
      P06.isPalindrome(List(1, 2, 2, 1)) should === (true)
      P06.isPalindrome(List(1, 2, 3, 3, 2, 1)) should === (true)
    }
  }

}
