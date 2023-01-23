trait Monad[M[_]]:
	def unit[A](a:A) : M[A]
	def bind[A,B](a:M[A], f: A => M[B]) : M[B]
end Monad

type Id[X] = X
object IdentityMonad extends Monad[Id]:
	override def unit[A](a: A): Id[A] = a
	override def bind[A, B](a: Id[A], f: A => Id[B]): Id[B] = f(a)
end IdentityMonad

def idFunc[A](i: A) : A = i

def idMonad[A](id : Monad[Id], i:A) = id.bind(i, idFunc)