trait Monad[M[_]]: 
	def unit[A](a: A): M[A]
	def bind[A, B](m: M[A], f: A => M[B]): M[B]
end Monad


// Continuation Monad 
def fCPS[R](n: Int): (String => R) => R = (f: String => R) => f(n.toString())
def gCPS[R](x: String): (Boolean => R) => R = (f: Boolean => R) => f((x == "7"))
def hCPS[R](b: Boolean): (Int => R) => R = (f: Int => R) => if b then f(7) else sys.error("other than 7")

// def clientCode = h(!g(f(8)))
def clCode_K[A] : (Int => A) => A = k => fCPS(7)((s: String) => gCPS(s)((b: Boolean) => hCPS(b)(k)))


trait ContMonad[R] extends Monad[[A] =>> ( A => R) => R]:
	type Cont[X] = (X => R) => R

	override def unit[A](a: A): Cont[A] = k => k(a)
	override def bind[A, B](m: (A => R) => R, f: A => Cont[B]) : Cont[B] = k => m(a => f(a) (k))
end ContMonad


object KonInt extends ContMonad[Int]

def cm_e1[A](m: ContMonad[A]) =
  m.bind(fCPS(7), (x: String) =>
    m.bind(gCPS(x), (b: Boolean) => hCPS(b)))

cm_e1(KonInt)(x => x + 3)

def cm_e2[A](m: ContMonad[A]) =
  m.bind(fCPS(77), (x: String) =>
    m.bind(gCPS(x), (b: Boolean) => hCPS(b)))

// return sys.error 
// cm_e2(KonInt)(x => x + 3)