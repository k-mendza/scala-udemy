package lectures.part1basics

object Expressions extends App {
  val x: Int = 1+2
  val y: Int = 2+3*4
  println(y == 14)
  var myVar = 3
  myVar + 5
  println(myVar == 8)
  // Instructions vs Expressions
  val condition = true
  val conditionedValue = if(condition) 5 else 3
  // if is expression not instruction
  println(conditionedValue)

  // NEVER write imperative programming in Scala
  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }

  val aUnitValue = (myVar = 5)
  println(aUnitValue)

  val codeBlock = {
    val y = 2
    val z = y + 1

    if (z > 2) "hello" else "bye"
  }

  println(codeBlock)
}
