trait Monad[M[_]]:
	def unit[A](a:A) : M[A]
	def bind[A,B](a:M[A], f: A => M[B]) : M[B]
end Monad

def fList(n: Int) : List[String] = List(n.toString())
def gList(s: String) : List[Boolean] = List(s == "7")
def hList(b: Boolean) : List[Int] = if b then List(7) else sys.error("other than 7")

def cl = fList(7).map(x => gList(x)).flatten.map(b => hList(b)).flatten

object MonadList extends Monad[List]:
	override def unit[A](a: A): List[A] = List(a)
	override def bind[A, B](a: List[A], f: A => List[B]): List[B] = 
		a.flatMap(f)
end MonadList

def cl_M (m: Monad[List]) = m.bind(m.bind(fList(7), gList), hList)

def cl_looping = (for
	x <- fList(7)
	y <- gList(x)
yield hList(y)).flatten

// List[Option[Int]] => Option[Int]

type OptX[M[_]] = [A] =>> M[Option[A]]

class MonadTrans[M[_]] (mlist : Monad[M]) extends  Monad[OptX[M]]:
	override def unit[A](a: A): OptX[M][A] = mlist.unit(Some(a))
	override def bind[A, B](a: OptX[M][A], f: A => OptX[M][B]): OptX[M][B] = mlist.bind(a, (z: Option[A]) => z match
		case Some(v) => f(v)
		case None => mlist.unit(None)
	)
end MonadTrans

val mt = new MonadTrans(MonadList)
def mt_e1 = mt.bind(List(Some(3), None), (x: Int) => mt.unit(x + 1))