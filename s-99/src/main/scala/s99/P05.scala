package s99

import scala.annotation.tailrec

object P05 {

  def reverse[E](list: List[E]): List[E] = {
    reverseRec(list, Nil)
  }

  @tailrec
  private[this] def reverseRec[E](current: List[E], result: List[E] = Nil): List[E] = {
    current match {
      case Nil          => result
      case head :: tail => reverseRec(tail, head :: result)
    }
  }

  def reverse2[E](list: List[E]): List[E] = 
    list.foldLeft(List.empty[E]) { (result, head) => head :: result }

}
