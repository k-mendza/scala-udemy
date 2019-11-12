package lectures.part2oop

object InheritanceAndTraits extends App {

  // single class inheritance
  class Animal {
    val creatureType: String = "generic"
    def eat: Unit = println("nomnomnom")
  }

  class Cat extends Animal {
    def crunch: Unit = {
      eat // super class protected method call
      println("crunch crunch")
    }
  }

  val cat = new Cat
  cat.crunch
  println(cat.creatureType)

  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name) // note the call to superclass constructor

  class Dog(override val creatureType: String) extends Animal {
//    override val creatureType: String = "domestic"
    override def eat: Unit = println("Dog crunch dog")
  }

  val dog = new Dog("K8")
  dog.eat
  println(dog.creatureType)

  // type substitution
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat
}
