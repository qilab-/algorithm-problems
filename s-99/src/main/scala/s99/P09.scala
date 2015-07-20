package s99

object P09 {

  def pack[E](list: List[E]): List[List[E]] = {
    list.foldRight(List.empty[List[E]]) { (e, r) =>
      r match {
        case l :: t if l.head == e => (e :: l) :: t
        case _ => List(e) :: r
      }
    }
  }

}
