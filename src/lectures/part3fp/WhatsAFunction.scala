package lectures.part3fp

object WhatsAFunction extends App {
  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  val concater = new ((String, String) => String) {
    override def apply(str1: String, str2: String): String = str1 + str2 
  }

  println(doubler(2))
  println(concater("Hello", "World!"))
}

trait MyFunction[A,B] {
  def apply(element: A): B
}

