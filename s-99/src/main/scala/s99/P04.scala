package s99

import scala.annotation.tailrec

object P04 {

  def length(list: List[_]): Int = {
    lengthRec(0, list)
  }

  @tailrec
  private[this] def lengthRec(n: Int, list: List[_]): Int = {
    list match {
      case Nil        => n
      case _ :: tail  => lengthRec(n + 1, tail)
    }
  }

  def length2(list: List[_]): Int = list.foldLeft(0) { (c, _) => c + 1 }

}
