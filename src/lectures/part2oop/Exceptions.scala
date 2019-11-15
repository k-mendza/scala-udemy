package lectures.part2oop

object Exceptions extends App {

  def isExceptionThrown(throwException: Boolean): Int = {
    if (throwException) throw new RuntimeException
    else 99
  }

  val myIntVal = try {
    isExceptionThrown(true)
  } catch {
    case e: RuntimeException => 11
  } finally {
    println("finally")
  }

  println(myIntVal)
}
