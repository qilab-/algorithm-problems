package s99

object P10 {

  def encode[E](list: List[E]): List[(Int, E)] = {
    P09.pack(list).map(l => (l.size, l.head))
  }

}
