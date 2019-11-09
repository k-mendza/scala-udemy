package lectures.part1basics

object CBNvsCBV extends App {
  def callByName(x: => Long): Unit = {
    println(x)
    println(x)
  }

  def callByValue(x: Long): Unit = {
    println(x)
    println(x)
  }

  callByName(System.nanoTime())
  callByValue(System.nanoTime())

  def infinite(): Int = 1 + infinite()
  def printer(x: Int, y: => Int): Unit = println(x)

//  printer(infinite(), 34)
  printer(34, infinite()) // this will not brake the code since operator => delays evaluation of passed expression until its needed
}
