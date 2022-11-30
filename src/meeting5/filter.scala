def filter (dList: List[Int])(f: (Int) => Boolean) : List[Int] = dList match
	case Nil => Nil 
	case (x :: xs) => f(x) match
		case true => x :: filter(xs)(f) 
		case false => filter(xs)(f)


def filterTV [A] (dList: List[A])(f: (A) => Boolean) : List[A] = dList match
	case Nil => Nil 
	case (x :: xs) => f(x) match
		case true => x :: filterTV(xs)(f) 
		case false => filterTV(xs)(f)
		
val aList = List(1,2,3,4)
val bList = List("Baz", "Bez", "Boz")

val o2_1 = filter(aList)((x) => (x % 2) == 0)
val o2_2 = filterTV(bList)((x) => x == "Bez")