package s99

import scala.annotation.tailrec

object P02 {

  def penultimate[E](list: List[E]): E = {
    list match {
      case _ :+ e :+ l => e
      case _           => throw new NoSuchElementException("The list size is less than 2.")
    }
  }

  @tailrec
  def penultimateRec[E](list: List[E]): E = {
    list match {
      case head :: _ :: Nil => head
      case _ :: _ :: tail   => penultimateRec(tail)
      case _                => throw new NoSuchElementException("The list size is less than 2.")
    }
  }

}
