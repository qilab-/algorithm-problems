package s99

object P02 {

  def penultimate[E](list: List[E]): E = {
    list match {
      case _ :+ e :+ l => e
      case _           => throw new NoSuchElementException("The list size is less than 2.")
    }
  }
}
