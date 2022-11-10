
// for 
// 	i <- 1 to 10 
// 	if i % 2 == 0
// 	if i > 6 
// do
// 	println(i)

val a = for
	i <- 1 to 5 
	j <- i to 5
	if j > i 
yield
	println(i)


// for
// 	x <- 1 to 10
// 	y <- List("Hello", "World")
// do
// 	println(s"x = $x, y = $y")

// val a = (1 to 10).foreach(x => List("Hello", "World").foreach(y =>println(s"x = $x, y = $y")))

def foo(n: Int, v: Int) = 
	for i <- 0 until n
		j <- 0 until n 
		if i + j == v 
	yield 
		i+j

var yB =
	for
		i <- 1 to 10
		y <- List("Hello", "World") 
	yield
		println("yield") 
		(i,y)

		

