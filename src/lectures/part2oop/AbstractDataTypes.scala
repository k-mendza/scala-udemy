package lectures.part2oop

object AbstractDataTypes extends App {

  abstract class Animal {
    val creatureType: String
    def eat: Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "Dog"
    override def eat: Unit = println("Dog eating")
  }

  // traits - "Interfaces"

  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  class Crocodile extends Animal with Carnivore {
    override val creatureType: String = "Crocodile"

    override def eat: Unit = println("Croc is eating")

    override def eat(animal: Animal): Unit = println(s"I'm a croc and I'm eating a ${animal.creatureType}")
  }

  val dog = new Dog;
  val croc = new Crocodile
  croc.eat(dog)
}
