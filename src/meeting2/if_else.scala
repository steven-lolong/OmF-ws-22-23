import scala.io.StdIn._
def numberChecking () : Unit =
	val inputNum = readLine("Input a number: ")
	if inputNum.toInt % 2 == 0 then 
		()


def print1to20 () : Unit =
	var number = 1 
	while
		number <= 20 
	do
		println(number) 
		number += 1

	
def triangleStar(): Unit =
	for(a <- 1 to 5) do 
		for(b <- 1 to 5) do
			if(b <= a) then 
				print("*")
		println("")

