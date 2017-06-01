#include <stdio.h>
#include <stdbool.h>

bool oppositeSigns(int x, int y)
{
    return ((x ^ y) < 0);
}

int main(void) {
	int x = 10;
	int y = -10;
	bool a = oppositeSigns(x, y);
	printf("%s\n", a ? "true" : "false");
	return 0;
}