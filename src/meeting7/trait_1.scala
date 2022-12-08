trait Dog:
	println("Dog") 
	var eyeColor: String = ""
	def ability(): String = "Walk"
end Dog

trait  Husky extends Dog:
	// override var eyeColor = "blue"
	// println(super.ability())
	println("Husky") 
	def ability2(): String = "Running"
end Husky

trait GermanSheperd extends Dog:
	// println(super.ability())
	// override var eyeColor = "orange"
	println("GS") 
	override def ability(): String = "Smart"
end GermanSheperd

class HybridDog extends  GermanSheperd, Husky:
	// println(super.ability())
end HybridDog

var hd = HybridDog()