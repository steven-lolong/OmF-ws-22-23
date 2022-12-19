def printMe[A](a : A) : Unit = a match
	case (b: Integer) => println(s"$b is integer")
	case (b: String) => println(s"'$b' is a string")
	case _ => println("Unknown type")

printMe(3)
printMe("hallo")
printMe[String]("Hallo")
printMe(3.2)
// printMe[Integer]("Hallo")