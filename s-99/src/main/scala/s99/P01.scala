package s99

import scala.annotation.tailrec

object P01 {

  def last[E](list: List[E]): E = {
    list match {
      case _ :+ e => e
      case _      => throw new NoSuchElementException("last of empty list")
    }
  }

  @tailrec
  def lastRec[E](list: List[E]): E = {
    list match {
      case head :: Nil => head
      case _ :: tail   => lastRec(tail)
      case _           => throw new NoSuchElementException("last of empty list")
    }
  }

}
