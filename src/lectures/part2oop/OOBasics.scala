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

class Writer(firstName: String, lastName: String, val yearOfBirth: Int) {
  def fullName(): String = s"$firstName $lastName"
}

class Novel(name: String, year: Int, author: Writer) {
  def authorAge(): Int = year - author.yearOfBirth
  def isWrittenBy(author: Writer): Unit = author == this.author
  def copy(newYear: Int): Novel = new Novel(name, newYear, author)
}

class Counter(val counter: Int) {
  def inc = new Counter(counter + 1)
  def inc(n: Int) = new Counter(counter + n)
  def dec = new Counter(counter - 1)
  def dec(n: Int) = new Counter(counter - n)
  def printCounter(): Unit = println(s"Counter value is: $counter")
}
