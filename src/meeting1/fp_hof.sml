val a = 5

val addA = fn(a) => fn(b) => a ^ b
val addB = addA("Hello")
val addC = addB(" World!")