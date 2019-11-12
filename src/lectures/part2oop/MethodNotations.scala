package lectures.part2oop

import scala.language.postfixOps

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def unary_! : String = s"what the heck?!"
    def unary_+ : Person = new Person(name, favoriteMovie, age + 1)
    def +(nickName: String) : Person = new Person(s"$name ($nickName)", favoriteMovie)
    def learns(subject: String) : String = s"$name learns $subject"
    def learnScala() : String = learns("Scala")
    def isAlive : Boolean = true
    def apply(): String = s"Hi, my name is $name and i like $favoriteMovie"
    def apply(n: Int) : String = s"$name watched $favoriteMovie $n times"
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception")

  val tom = new Person("Tom", "Fight Club")
  println(mary hangOutWith tom)

  // all operators are methods

  // prefix notation
  val x = -1
  val y = 1.unary_-
  println(!mary)
  println(mary.unary_!)

  // postfix notation
  println(mary.isAlive) // standard
  println(mary isAlive) // sugar

  // apply
  println(mary.apply())
  println(mary())
}
