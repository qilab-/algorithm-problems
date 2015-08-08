package s99

object P15 {

  def duplicateN[E](n: Int, l: List[E]): List[E] = {
    l.flatMap(List.fill(n)(_))
  }

  def duplicateNRec[E](n: Int, l: List[E]): List[E] = {
    duplicateNRec(n, l, List.empty[E])
  }

  private[this] def duplicateNRec[E](n: Int, l: List[E], result: List[E]): List[E] = {
    l match {
      case h :: t => duplicateNRec(n, t, copyN(n, h, Nil) ++ result)
      case Nil => result.reverse
    }
  }

  private[this] def copyN[E](n: Int, e: E, result: List[E]): List[E] = {
    if (n <= 0)
      result
    else
      copyN(n - 1, e, e :: result)
  }

}
