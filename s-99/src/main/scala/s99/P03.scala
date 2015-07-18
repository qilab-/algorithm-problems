package s99

import scala.annotation.tailrec

object P03 {

  def nth[E](n: Int, list: List[E]): E = {
    require(n >= 0, "n must be greater than or equal to 0")
    if (n >= list.size) {  // list.size takes O(list.size)
      throw new NoSuchElementException(
        s"n is greater than or equal to the size of the list. n = $n, list size = ${list.size}"
      )
    } else {
      nthRec(n, list)
    }
  }

  @tailrec
  private[this] def nthRec[E](n: Int, list: List[E]): E = {
    if (n == 0)
      list.head
    else
      nthRec(n - 1, list.tail)
  }

  @tailrec
  def nth2[E](n: Int, list: List[E]): E = {
    (n, list) match {
      case (_, Nil)       => throw new NoSuchElementException
      case (0, head :: _) => head
      case (m, _ :: tail) => nth2(m - 1, tail)
    }
  }

}
