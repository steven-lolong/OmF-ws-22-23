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
	print("env in h is " + x.toString() + " \n")
	if b then 7 else sys.error("Other than 7")

	
val env = 777
// def clientC = h(g(f(8)))
// hRead(gRead(fRead(7)))
def client(env: Int) = hRead(gRead(fRead(7)(env))(env))(env)

trait ReaderMonad[R] extends Monad[[A] =>> R => A]:
	override def unit[A](a: A): R => A = (_) => a
	override def bind[A, B](a: R => A, f: A => R => B): R => B = 
		(n: R) => f(a(n))(n)
end ReaderMonad

object RM extends ReaderMonad[Int]

def cRM (env: Int, m : ReaderMonad[Int]) = 
	m.bind(fRead(7), (s: String) => m.bind(gRead(s),
	(b: Boolean) => hRead(b))) (env)