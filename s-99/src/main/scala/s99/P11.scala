package s99

object P11 {

  def encodeModified[E](list: List[E]): List[Any] = {
    P09.pack(list).map { l =>
      val s = l.size
      val h = l.head
      if (s == 1) h else (s, h)
    }
  }

}
