#include <stdio.h>

void goTo()
{
	goto newJump;
	printf("Hey....!");

newJump:
	printf("Just jump");
}
int main(int argc, char *argv[])
{
	int a = 0;
	for (int i = 0; i < 10; i++)
	{
		a++;
		continue;
		printf("a\n");
	}
	printf("%d \n", a);

	return 0;
}