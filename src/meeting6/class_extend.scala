class Dog :

	var eyeColor : String = ""
	protected def ability() : String = "walk"
end Dog

class Wolf:
	var eyeColor : String = ""
	protected def ability() : String = "strong"
end Wolf

// no multiple extends
// class Husky (hight: Int) extends Dog, Wolf:
class Husky (hight: Int) extends Dog:
	eyeColor = "blue"
	// def ability(): String = "run fast"
	println(ability())

end Husky

class GermanSheperd extends Dog:
	eyeColor = "blue"
	// def ability(): String = "smart"

end GermanSheperd

var dogA = Dog()
// println(dogA.ability())
var gs = GermanSheperd()
// println(gs.ability())

