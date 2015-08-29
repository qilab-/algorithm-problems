package s99

object P17 {

  def split[E](n: Int, l: List[E]): (List[E], List[E]) = {
    l.splitAt(n)
  }

  def splitRec[E](n: Int, l: List[E]): (List[E], List[E]) = {
    splitR(n, Nil, l)
  }

  @scala.annotation.tailrec
  private[this] def splitR[E](n: Int, l: List[E], r: List[E]): (List[E], List[E]) = {
    r match {
      case h :: t if n > 0 => splitR(n - 1, h :: l, t)
      case _ => (l.reverse, r)
    }
  }

}
