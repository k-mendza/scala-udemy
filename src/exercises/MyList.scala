package exercises

import java.util.NoSuchElementException

abstract class MyList[+A] {
  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](element: B ): MyList[B]
  def printElements: String
  override def toString: String = "[" + printElements + "]"
  def map[B] (transformer: MyTransformer[A, B]): MyList[B]
  def flatMap[B] (transformer: MyTransformer[A, MyList[B]]): MyList[B]
  def filter(predicate: MyPredicate[A]): MyList[A]
  def ++[B >: A](list: MyList[B]): MyList[B]
}

object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)
  def printElements: String = ""
  def map[B] (transformer: MyTransformer[Nothing, B]): MyList[B] = Empty
  def flatMap[B] (transformer: MyTransformer[Nothing, MyList[B]]): MyList[B] = Empty
  def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = Empty
  def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
}

class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head: A = h
  def tail: MyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element: B): MyList[B] = new Cons(element, this)
  def printElements: String = {
    if (t.isEmpty) "" + h
    else h + " " + t.printElements
  }
  def map[B] (transformer: MyTransformer[A, B]): MyList[B] = {
    new Cons(transformer.transform(h), t.map(transformer))
  }
  def flatMap[B] (transformer: MyTransformer[A, MyList[B]]): MyList[B] = {
    transformer.transform(h) ++ t.flatMap(transformer)
  }
  def filter(predicate: MyPredicate[A]): MyList[A] = {
    if (predicate.test(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)
  }
  def ++[B >: A](list: MyList[B]): MyList[B] = new Cons(h, t ++ list)
}

trait MyPredicate[-T] {
  def test(element: T): Boolean
}

trait MyTransformer[-A, B] {
  def transform(element: A): B
}

object ListTest extends App {
  val listOfIntegers = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val anotherListOfIntegers = new Cons(4, new Cons(5, new Cons(6, Empty)))
  val listOfStrings = new Cons("Hello", new Cons("world", Empty))

  println(listOfIntegers.toString)
  println(listOfStrings)

  println((listOfIntegers ++ anotherListOfIntegers).toString)
  println(listOfIntegers.flatMap((element: Int) => new Cons[Int](element, new Cons[Int](element + 1, Empty))).toString)
}
