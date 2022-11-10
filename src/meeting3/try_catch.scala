def divX(vD : Double, divD: Double) = divD match
	case 0 => throw new ArithmeticException("Error! divider is zero")
	case _ => vD / divD

def testDiv = 
	try
		divX (3 ,1)
	catch
		case ex: ArithmeticException => ex.printStackTrace() 
	finally
		println("the last step")

