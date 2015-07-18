package s99

object P01 {

  def last[E](list: List[E]): E = {
    list match {
      case _ :+ e => e
      case _      => throw new NoSuchElementException("last of empty list")
    }
  }

}
