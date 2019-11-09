package lectures.part1basics

object StringOps extends App {

  // s interpolated String
  val name = "John"
  val age = 13
  val sstr = s"Hi $name you will be ${age + 1} next year!"
  println(sstr)

  // f interpolated String

  // raw String
  println(raw"This is raw \n string")
  val rawString = "This is first line\n and this is second one"
  println(raw"$rawString")
}
