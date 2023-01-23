def f(i: Int) : String = i.toString()
def g(s: String) : Boolean = s == "7"
def h(b: Boolean) : Int = if b then 7 else sys.error("Other than 7")

// fn(parameter)
// h(g(f(8)))
// h . g . f(8)

def >>=[A,B](a: A, f: A => B) : B = f(a)
>>=(8,f)
f(8)

// h . g . f(8)
h(g(f(7)))
>>=(>>=(>>=(7,f), g), h)

trait Monad[M[_]]:
	def unit[A](a:A) : M[A]
	def bind[A,B](a:M[A], f: A => M[B]) : M[B]
end Monad


type S[X] = X
object SimpleMonad extends Monad[S]:
	override def unit[A](a: A): S[A] = a
	override def bind[A, B](a: S[A], f: A => S[B]): S[B] = f(a)
end SimpleMonad

def addNbN(s: String) : String = s + "\n b \n"

def res_monadic(sm: Monad[S]) = (s: String) => sm.bind(s, addNbN)

res_monadic(SimpleMonad)("Hello")
addNbN("Hello") 