package lectures.part2oop

object OOBasics extends App {
  val person = new Person("John", 29)
  println(person)
  println(person.age)
  person.greet("Mark")
}

class Person(name: String, val age: Int) {
  def greet(name: String) = println(s"${this.name} says: Hi, $name!")

  def this(name: String) = this(name, 0)

  def this() = this(name = "Paul")
}
