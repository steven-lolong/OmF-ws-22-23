class Dog:
	// println("Dog") 
	var eyeColor: String = ""
	def ability(): String = "Walk"
end Dog

case class Husky (height: Int) extends Dog:
	// override var eyeColor = "blue"
	// println(super.ability())
	// println("Husky") 
	override def ability(): String = "Running"
end Husky

case class GermanSheperd (height: Int) extends Dog:
	// println(super.ability())
	// override var eyeColor = "orange"
	// println("GS") 
	override def ability(): String = "Smart"
end GermanSheperd

def checkIt(a: Dog) : String = a match
	case Husky(8) => "Husky 8"
	case Husky(9) => "Husky 9"
	case GermanSheperd(_) => "GermanSheperd"
	case _ => "Unknown"

var hs = Husky(8);
var hs1 = Husky(9);

println(checkIt(hs))

