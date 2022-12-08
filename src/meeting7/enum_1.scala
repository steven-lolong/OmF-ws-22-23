enum Exp:
	case Value(n: Int) extends Exp
	case Plus(lsh: Exp, rhs: Exp) extends Exp
	case Subtc(lsh: Exp, rhs: Exp) extends Exp
	case Divd(lsh: Exp, rhs: Exp) extends Exp
	case Mult(lsh: Exp, rhs: Exp) extends Exp
end Exp

import Exp._

def evaluator(e: Exp) : Int = e match
	case Value(a) => a 
	case Plus(l, r) => evaluator(l) + evaluator(r)
	case Subtc(l, r) => evaluator(l) - evaluator(r)
	case Divd(l, r) => evaluator(l) / evaluator(r)
	case Mult(l, r) => evaluator(l) * evaluator(r)

// 1 + 2
val oneTwo = Plus(Value(1), Value(2))
// 3 - 2
val threeTwo = Subtc(Value(3), Value(2))
// (4/2) + 3
val ts_1 = Plus(Divd(Value(4), Value(2)), Value(3))

evaluator(oneTwo)
evaluator(threeTwo)

