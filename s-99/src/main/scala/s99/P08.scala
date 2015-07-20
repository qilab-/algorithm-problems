package s99

object P08 {

  def compress[E](list: List[E]): List[E] = {
    list.foldRight(List.empty[E]) { (e, r) =>
      r match {
        case h :: _ if h == e => r
        case _                => e :: r
      }
    }
  }

}
