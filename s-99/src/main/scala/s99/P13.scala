package s99

import scala.annotation.tailrec

object P13 {

  def encodeDirect[E](list: List[E]): List[(Int, E)] = {
    list.foldRight(List.empty[(Int, E)]) { (e, r) =>
      r match {
        case h :: t if h._2 == e => (h._1 + 1, e) :: t
        case h :: t if h._2 != e => (1, e) :: r
        case Nil => (1, e) :: Nil
      }
    }
  }

  def encodeDirectRec[E](list: List[E]): List[(Int, E)] = {
    encodeD(list, Nil)
  }

  @tailrec
  private[this] def encodeD[E](list: List[E], result: List[(Int, E)]): List[(Int, E)] = {
    if (list.isEmpty) {
      result.reverse
    } else {
      val h = list.head
      val (packed, next) = list.span(_ == h)
      encodeD(next, (packed.size, h) :: result)
    }
  }

}
