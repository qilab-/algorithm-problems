package s99

import scala.annotation.tailrec

object P03 {

  def nth[E](n: Int, list: List[E]): E = {
    require(n >= 0, "n must greater than or equal to 0")
    if (n >= list.size) {
      throw new NoSuchElementException(
        s"n is greater than or equal to the size of the list. n = $n, list size = ${list.size}"
      )
    } else {
      nthRec(n, list)
    }
  }

  @tailrec
  private[this] def nthRec[E](n: Int, list: List[E]): E = {
    n match {
      case 0 => list.head
      case _ => nthRec(n - 1, list.tail)
    }
  }
}
