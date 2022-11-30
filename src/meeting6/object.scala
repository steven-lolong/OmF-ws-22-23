// class Dog:
// 	val eyeColor = "brown"
// end Dog
// val Dog = Dog()

object Dog:
	val eyeColor = "brown"
end Dog

println(Dog.eyeColor)

// error, it doesn't support parameter
// object Cat (var abilit: String):
object Cat (var abilit: String):
	val eyeColor = "brown"
end Cat

