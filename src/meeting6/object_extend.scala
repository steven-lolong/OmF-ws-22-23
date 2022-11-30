object Dog:
	var eyeColor = "blue"
end Dog

// this is error because object can't be a parent class 
object Husky extends Dog:
	println("Husky")
end Husky