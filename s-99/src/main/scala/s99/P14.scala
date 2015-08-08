package s99

object P14 {

  def duplicate[E](l: List[E]): List[E] = {
    l.foldRight(List.empty[E]) { (e, r) => e :: e :: r }
  }

  def duplicateRec[E](l: List[E]): List[E] = {
    duplicateRec(l, Nil)
  }

  @scala.annotation.tailrec
  private[this] def duplicateRec[E](l: List[E], result: List[E]): List[E] = {
    l match {
      case h :: t => duplicateRec(t, h :: h :: result)
      case Nil => result.reverse
    }
  }

}
