class Dog[A]:
	def printMe(a: A) : Unit = a match
		case (b: Integer) => println(s"$b is integer")
		case (b: String) => println(s"'$b' is a string")
		case _ => println("Unknown type")
end Dog

// val dogA = Dog[Integer]()
// dogA.printMe("Hallo")
val dogA = Dog[Any]()
dogA.printMe("Hallo")