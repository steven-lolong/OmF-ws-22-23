trait Monad[M[_]]:
	def unit[A](a:A) : M[A]
	def bind[A,B](a:M[A], f: A => M[B]) : M[B]
end Monad

def fOp(i: Int) : Option[String] = if(i < 100) Some(i.toString()) else None
def gOp(s: String) : Option[Boolean] = Some(s == "7")
def hOp(b: Boolean) : Option[Int] = if(b) Some(7) else None

// h . g . f(7)
// h(g(f(7)))

// hOp(gOp(fOp(7)))
def newBind(i: Int)= fOp(i) match
	case Some(s) => gOp(s) match
		case Some(b) => hOp(b)
		case None => None
	case None => None

val nBOldStyle = newBind(7)

object OptionMonad extends Monad[Option]:
	override def unit[A](a: A): Option[A] = Some(a)
	override def bind[A, B](a: Option[A], f: A => Option[B]): Option[B] = a match
		case Some(x) => f(x)
		case None => None
end OptionMonad

def newMonadicBind(op: Monad[Option], i: Int) = op.bind(op.bind(fOp(i), gOp), hOp)
val nBMonadic = newMonadicBind(OptionMonad, 7)
	