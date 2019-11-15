package lectures.part2oop

object CaseClasses extends App {
  case class Person(name: String, age: Int)

  val jim = Person("Jim", 34)
  println(jim)

  //1. class params as fields
  //2. toString
  //3. equals and hasCode implemented
  //4. copy method
  //5. companion objects
  //6. serializable
  //7. extractor patterns - can be used in PATTERN MATCHING


}
