package lectures.part1basics

object StringOps extends App {

  // s interpolated String
  val name = "John"
  val age = 13
  val sStr = s"Hi $name you will be ${age + 1} next year!"
  println(sStr)

  // f interpolated String
  val fStr = f"Formatted value of 1 is ${1f}%2.2f"
  println(fStr)

  // raw String
  println(raw"This is raw \n string")
  val rawString = "This is first line\n and this is second one"
  println(raw"$rawString")
}
