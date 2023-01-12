def f(i: Int) : String = i.toString()
def g(s: String) : Boolean = s == "7"
def h(b: Boolean) : Int = if b then 7 else sys.error("Other than 7")

def clientCode = h(!g(f(8)))
def clientCode1 = h(g(f(8)))

def fOp(i: Int): Option[String] = if (i < 100) Some(i.toString()) else None
def gOp(s: String): Option[Boolean] = Some(s == "7")
def hOp(b: Boolean): Option[Int] = if (b) Some(7) else None

def clientCode2 = fOp (8) match
	case Some(x) => gOp(x) match
		case Some(y) => hOp(!y) 
		case None => None
	case None => None

def fOl(i: Int): Option[String] = if (i < 100) Some(i.toString()) else None

def gOl(s: Option[String]): Option[Boolean] = s match
	case Some(x) => Some(x == "7")
	case None => None

def hOl(b: Option[Boolean]): Option[Int] = b match
	case Some(x) => if (x) then Some(7) else None 
	case None => None

def clientCode3 = hOl(gOl(fOl(8)))

def bindOption[A, B](a: Option[A], f: A => Option[B]): Option[B] = a match
	case Some(x) => f(x) 
	case None => None

def clientCode4 = bindOption(bindOption(fOp(8), gOp), hOp)

def clientCodeOpBind = bindOption(fOp(8), (x: String) => bindOption(gOp(x), (y: Boolean) => hOp(y)))

