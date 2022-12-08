abstract class Dog:
  println("Dog")
  var eyeColor : String = ""
  def ability() : String = "walk"
  def running() : Unit = 
    println("run Faster")
end Dog

//abstract class support constructor's parameter
abstract class Husky(height: Int) extends Dog:
  println("Husky")
  eyeColor = "blue"
  override def ability() : String = "Run faster"
end Husky

abstract class GermanSheperd extends Dog:
  println("GermanSheperd")
  override def ability(): String = "Smart"
end GermanSheperd
//abstract class cannot using in mixin
//class mixDog extends GermanSheperd, Husky{
//  println(super.ability())
//}

class mixDog extends GermanSheperd{
  println(super.ability())
}

//error! abstract class cannot be instantiated
//val gs = GermanSheperd
//println(mixdog.ability())