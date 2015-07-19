package s99

import scala.annotation.tailrec

object P06 {

  // At the worst case: O((1 + n) * (n / 2)) = O(n^2)
  @tailrec
  def isPalindrome(list: List[_]): Boolean = {
    list match {
      case Nil | _ :: Nil                         => true
      case head +: middle :+ last if head == last => isPalindrome(middle)
      case _                                      => false
    }
  }

}
