package lectures.part1basics

object Functions extends App {
  def greetingFunction(name: String, age: Int): Unit = {
    println("Hi, my name is " + name + " and i'm " + age + " years old")
  }

  def factorial(factorialBase: Int): Long = {
    if (factorialBase <= 0) 1
    else factorialBase * factorial(factorialBase - 1)
  }

  println(factorial(20))

  def fibonacci(elemNumber: Int): Long = {
    if (elemNumber <= 2 ) 1
    else fibonacci(elemNumber - 1) + fibonacci(elemNumber - 2)
  }

  println(fibonacci(20))

  def isPrime(number: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean = {
      if (t <= 1) true
      else number % t != 0 && isPrimeUntil(t - 1)
    }
    isPrimeUntil(number/2)
  }

  println(isPrime(37*17))

}
