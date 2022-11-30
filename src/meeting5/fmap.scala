
def fMap(f:(Int) => Int)(dList: List[Int]) : List[Int] = dList match
	case Nil => Nil
	case head :: next => f(head) :: fMap(f)(next)

def fMapTV1[A](f:(A) => A)(dList: List[A]) : List[A] = dList match
	case Nil => Nil
	case head :: next => f(head) :: fMapTV1(f)(next)

def fMapTV2[A,B](f:(A) => B)(dList: List[A]) : List[B] = dList match
	case Nil => Nil
	case head :: next => f(head) :: fMapTV2(f)(next)

val aList = List(1,2,3,4)
val aListStr = List("Hello", " World!")

val o2 = fMap((x) => x + 1) (aList)
val o2_1 = fMapTV1[Int]((x) => x + 1) (aList)
val o2_2 = fMapTV1((x:String) => x + " A") (aListStr)
val o2_3 = fMapTV2[Int,String]((x) => x.toString()) (aList)