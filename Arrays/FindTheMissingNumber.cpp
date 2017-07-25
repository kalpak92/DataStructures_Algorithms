/*
You are given a list of n-1 integers and these integers are in the range of 1 to n. 
There are no duplicates in list. One of the integers is missing in the list. 
Write an efficient code to find the missing integer.

Example:
I/P    [1, 2, 4, ,6, 3, 7, 8]
O/P    5

Algorithm:

        1) XOR all the array elements, let the result of XOR be X1.
        2) XOR all numbers from 1 to n, let XOR be X2.
        3) XOR of X1 and X2 gives the missing number.

Time Complexity: O(n)
*/

#include <iostream>
using namespace std;

int getMissingNo(int arr[], int size) {
    int num;
    int x1 = arr[0];
    int x2 = 1;
    
    for (int i = 1; i < size; i++)
        x1 = x1 ^ arr[i];
    
    for (int i = 2; i <= size+1; i++)
        x2 = x2 ^ i;
    
    return (x1 ^ x2);
}

int main() {
	int a[] = {1, 2, 4, 5, 6};
	int n = sizeof(a)/sizeof(a[0]);
    int missing_number = getMissingNo(a, n);
    cout <<"The missing number is "<< missing_number <<".\n";
	return 0;
}
