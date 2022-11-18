def mult (a: Int, b: Int) : Int = 
	a * b



def idf [A](a: A) : A = a 

val xid = idf(5)

val xid1 = idf("Hallo")

// this is error
// def multA[A](a:A, b:A) : A = a * b 

def multThenSquare(a: Int, b: Int): Int =
	def squareIt(x: Int) : Int =
		x * x
	squareIt(a * b)

val _36 = multThenSquare(2,3)

// This is lambda 
val xLambda = (a: Int) => a + a
// this is the same
// def xLambda(a: Int) = a + a

val xLambda1 : (Int) => Int = (a: Int) => 6

def abMult(fa : (Int, Int) => Int, a: Int, b: Int) : Int = fa(a,b)

