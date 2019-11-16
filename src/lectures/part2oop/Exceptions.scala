package lectures.part2oop

import java.nio.{BufferOverflowException, BufferUnderflowException}

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

  class MyException extends Exception
  val exception = new MyException
//  throw exception

  object PocketCalculator {
    def add(x: Int, y: Int): Int = {
      val result = x + y
      if ( x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result
    }
    def subtract(x: Int, y: Int): Int = {
      val result = x - y
      if ( x > 0 && y < 0 && result < 0) throw new OverflowException
      else if ( x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }
    def multiply(x: Int, y: Int): Int = {
      val result = x * y
      if ( x > 0 && y > 0 && result < 0) throw new OverflowException
      else if ( x < 0 && y < 0 && result < 0) throw new OverflowException
      else if ( x > 0 && y < 0 && result > 0) throw new UnderflowException
      else if ( x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }
    def divide(x: Int, y: Int): Int = {
      if (x == 0 | y == 0) throw new MathCalculationException
      else x / y
    }
    class OverflowException extends Exception
    class UnderflowException extends Exception
    class MathCalculationException extends Exception
  }

//  println(PocketCalculator.add(Int.MaxValue, 10))

}
