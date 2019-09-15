#include <iostream>
using namespace std;

int setABit(int n, int k){
	if (k <= 0)
		return n;
	
	// Shift 1 to the kth position and then combine it by ORing the same.
	return (n | (1 << (k - 1)));
}

int main(void){
	int n = 9;
	int k = 5;

	cout << "The number "<< n << " with " << k <<"th bit set is " << setABit(n, k) << "." << endl;

	return 0;
}