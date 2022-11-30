class Dog (val eyeColor: String)
var dogA = Dog("blue")
println(dogA.eyeColor)

class Cat(eyeColor: String):
	println("hello from Katty")
	def printIt() = eyeColor
	println("by from Katty")
end Cat

var catA = Cat("yellow")
println(catA.printIt())
// error
// println(catA.eyeColor)