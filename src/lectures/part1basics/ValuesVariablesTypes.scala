package lectures.part1basics

object ValuesVariablesTypes extends App {
  val x: Int = 33
  println(x)
  // val are immutable used for storage not to be changed
  val y = 22
  // compiler can infer types
  println(y.getClass)
  // y is int
  val str: String = "String"
  println(str)
  val bool: Boolean = false
  val char: Char = 'a'
  val short: Short = 1234
  val long: Long = 123412341234L
  // decimal types
  val aFloat: Float = 2.0F
  val aDouble: Double = 3.14

  // variables
  var varInt: Int = 4
  varInt = 1
  varInt += 1
  println(varInt)
  // variables are mutable and can be modified after creation
}
