def fHoFArithOptCurrying (a: Int) (b: Int) (f: (Int, Int) => Int) : Int = f(a,b)

val needB = fHoFArithOptCurrying (4)
val needF = needB (3)
val needX = fHoFArithOptCurrying (4)(5) 
val ex2_seven = needF((a: Int, b:Int) => a + b)

