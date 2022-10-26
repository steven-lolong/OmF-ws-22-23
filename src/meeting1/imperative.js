const a = 1;
console.log(a);

justJump: while (true) {
	console.log(a)
	a++;
	if (a < 11) continue justJump;

	break;

}