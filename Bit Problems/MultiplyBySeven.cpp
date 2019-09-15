#include <iostream>
using namespace std;

unsigned int getMultiplyBySeven(unsigned int n){
	return ((n << 3) - n);
}

int main(void)
{
	unsigned int n = 123456789;
	cout << "Multiplying " << n << " by 7 gives " << getMultiplyBySeven(n) << endl;

	return 0;
}