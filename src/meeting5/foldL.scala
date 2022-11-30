def foldR(dList: List[Int])(acc: Int)(f: (Int, Int) => Int) : Int = dList match
	case Nil => acc
	case head :: tail => f(head, foldR(tail)(acc)(f))


def foldL(dList: List[Int])(acc: Int)(f: (Int, Int) => Int) : Int = dList match
	case Nil => acc
	case head :: tail => foldL(tail)(f(acc,head))(f)
