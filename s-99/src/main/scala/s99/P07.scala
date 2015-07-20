package s99

object P07 {

  def flatten(list: List[_]): List[Any] = {
    list.foldRight(List.empty[Any]) { (e, r) =>
      e match {
        case l: List[_] => flatten(l) ++ r
        case _ => e :: r
      }
    }
  }

  def flatten2(list: List[_]): List[Any] = {
    list flatMap {
      case l: List[_] => flatten2(l)
      case e => List(e)
    }
  }

}
