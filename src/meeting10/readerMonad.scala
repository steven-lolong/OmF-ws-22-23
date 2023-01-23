trait Monad[M[_]]:
	def unit[A](a:A) : M[A]
	def bind[A,B](a:M[A], f: A => M[B]) : M[B]
end Monad

def fRead(i: Int) : Int => String = (x : Int) => 
	print("env in f is " + x.toString() + " \n")
	i.toString()

def gRead(s: String) : Int => Boolean = (x: Int) =>
	print("env in g is " + x.toString() + " \n")
	(s == "7")

def hRead(b: Boolean) : Int => Int = (x: Int) =>
	print("env in g is " + x.toString() + " \n")
	if b then 7 else sys.error("Other than 7")

// hRead(gRead(fRead(7)))
val env = 777

def comFunc(i: Int, e: Int) =  