let a = 5; //mutable
const b = 7; //immutable

let addA = (a, b) => { return (a + b); }
let addB = (fadd, c, d) => { return (fadd(c, d)); }
let addC = (e, f) => { return (e + f); }

let mulA = (a) => { return ((b) => { return (a * b) }) }

let mulB = mulA(4);
// (b) => { return (4 * b) }
let mulC = mulA(4)(5);
// return (4 * 5)

let res1 = mulB(3);

// console.log(addB(addA, 5, 10));//{return {return 5 + 10}}
// console.log(addC(addA(3, 5), 7));//{return {8 + 7}}