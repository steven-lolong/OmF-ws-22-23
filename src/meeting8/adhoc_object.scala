// trait MixItUp[A]:
// 	def mixIt(a: A, b: A) : A 
// end MixItUp

// object ImMixInt extends MixItUp[Int]:
// 	override def mixIt(a: Int, b: Int): Int = a + b
// end ImMixInt

// object ImMixString extends MixItUp[String]:
// 	override def mixIt(a: String, b: String): String = a + b
// end ImMixString

// def combine[A](x: A, y:A) (mix: MixItUp[A]) : A = mix.mixIt(x,y)

trait MixItUp[A]:
	def mixIt(a: A, b: A) : A 
end MixItUp

implicit object ImMixInt extends MixItUp[Int]:
	override def mixIt(a: Int, b: Int): Int = a + b
end ImMixInt

implicit object ImMixString extends MixItUp[String]:
	override def mixIt(a: String, b: String): String = a + b
end ImMixString

def combine[A](x: A, y:A) (implicit mix: MixItUp[A]) : A = mix.mixIt(x,y)

println(combine(3,4))

// Have a nice Semester Holyday see you in 2023