package s99

object P16 {

  def drop[E](n: Int, l: List[E]): List[E] = {
    l.zipWithIndex.filter(t => (t._2 + 1) % n != 0).map(_._1)
  }

  def dropRec[E](n: Int, l: List[E]): List[E] = {
    @scala.annotation.tailrec
    def dropR[E](c: Int, cl: List[E], result: List[E]): List[E] = {
      (c, cl) match {
        case (_, Nil) => result.reverse
        case (1, _ :: t) => dropR(n, t, result)
        case (_, h :: t) => dropR(c - 1, t, h :: result)
      }
    }

    dropR(n, l, Nil)
  }

}
