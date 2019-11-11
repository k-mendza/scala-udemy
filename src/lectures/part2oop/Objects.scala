package lectures.part2oop

object Objects extends App {

  object Person {
    val EYE_NUMBER = 2
    def canFly : Boolean = false

    def apply(name: String, age: Int): Person = new Person(name, age)
  }

  class Person(name: String, age: Int) {
    def printValues(): String = s"name: $name\nage: $age"
  }

  println(Person("Mary", 26).printValues())
}
