package s99

object P12 {

  def decode[E](l: List[(Int, E)]): List[E] = {
    l.flatMap { case (i, e) => List.fill(i)(e) }
  }
}
