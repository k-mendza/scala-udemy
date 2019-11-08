package lectures.part1basics

object Recursion extends App {
  def factorial(factorialBase: Int): Long = {
    if (factorialBase <= 1) 1
    else factorialBase * factorial(factorialBase - 1)
  }

  def bigFactorial(n: Int): BigInt = {
    def helper(x: Int, accumulator: BigInt): BigInt = {
      if (x <= 1) accumulator
      else helper(x-1, x*accumulator) // tail recursion
    }
    helper(n, 1)
  }

  println(bigFactorial(50000))
}
