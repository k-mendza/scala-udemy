package exercises

import java.util.NoSuchElementException

abstract class MyList[+A] {
  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](element: B ): MyList[B]
  def printElements: String
  override def toString: String = "[" + printElements + "]"
  def map[B] (transformer: A => B): MyList[B]
  def flatMap[B] (transformer: A => MyList[B]): MyList[B]
  def filter(predicate: A => Boolean): MyList[A]
  def ++[B >: A](list: MyList[B]): MyList[B]
}

case object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)
  def printElements: String = ""
  def map[B] (transformer: Nothing => B): MyList[B] = Empty
  def flatMap[B] (transformer: Nothing => MyList[B]): MyList[B] = Empty
  def filter(predicate: Nothing => Boolean): MyList[Nothing] = Empty
  def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
}

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head: A = h
  def tail: MyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element: B): MyList[B] = Cons(element, this)
  def printElements: String = {
    if (t.isEmpty) "" + h
    else h + " " + t.printElements
  }
  def map[B] (transformer: A => B): MyList[B] = {
    new Cons(transformer(h), t.map(transformer))
  }
  def flatMap[B] (transformer: A => MyList[B]): MyList[B] = {
    transformer(h) ++ t.flatMap(transformer)
  }
  def filter(predicate: A => Boolean): MyList[A] = {
    if (predicate(h)) Cons(h, t.filter(predicate))
    else t.filter(predicate)
  }
  def ++[B >: A](list: MyList[B]): MyList[B] = new Cons(h, t ++ list)
}

object ListTest extends App {
  val listOfIntegers = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val anotherListOfIntegers = new Cons(4, new Cons(5, new Cons(6, Empty)))
  val listOfStrings = new Cons("Hello", new Cons("world", Empty))

  println(listOfIntegers.toString)
  println(listOfStrings)

  println((listOfIntegers ++ anotherListOfIntegers).toString)
  println(listOfIntegers.flatMap(new Function1[Int, MyList[Int]] {
    override def apply(): = new (element: Int): MyList[Int] = new Cons(element, new Cons(element+1,Empty))
  }).toString)
}
