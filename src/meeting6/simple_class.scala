class Dog :

	var eyeColor : String = ""
	def ability() : String = "walk"
end Dog

var dogA = Dog()
var dogB = Dog()

dogA.eyeColor = "blue"
dogB.eyeColor = "yellow"

println(dogA.eyeColor)
println(dogB.eyeColor)