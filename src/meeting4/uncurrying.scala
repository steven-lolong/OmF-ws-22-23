
def fHoFArithOptUncurrying (a: Int, b: Int, f: (Int,Int)=>Int) : Int = f(a,b)
val ex3_seven = fHoFArithOptUncurrying(4, 3, (a: Int, b: Int) => a + b)
val needBUc = fHoFArithOptUncurrying(_, 3 , _)
