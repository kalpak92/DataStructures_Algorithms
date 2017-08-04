/*
Arrange given numbers to form the biggest number.

Given an array of numbers, arrange them in a way that yields the largest value.
For example, 
    if the given numbers are {54, 546, 548, 60}, 
    the arrangement 6054854654 gives the largest value. 
    
    And if the given numbers are {1, 34, 3, 98, 9, 76, 45, 4}, 
    then the arrangement 998764543431 gives the largest value.
*/

#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int myCompare(string X, string Y)
{
	// first append Y at the end of X
	string XY = X.append(Y);

	// then append X at the end of Y
	string YX = Y.append(X);

	// Now see which of the two formed numbers is greater
	return XY.compare(YX) > 0 ? 1 : 0;
}

void getLargestNumber(int arr[], int n) {
    vector<string> a;
    
    for(int i=0; i<n; i++)
        a.push_back(to_string(arr[i]));
    
    sort(a.begin(), a.end(), myCompare);
    
    cout << "The Largest Number Formed is: ";
    for (int i=0; i<a.size(); i++)
        cout <<a[i];
    cout << "\n";
}

int main() {
	int arr1[] = {54, 548, 546, 60};
	int size = sizeof(arr1)/sizeof(arr1[0]);
	getLargestNumber(arr1,size);
	
	int arr2[] = {7, 776, 77, 7};
	size = sizeof(arr2)/sizeof(arr2[0]);
	getLargestNumber(arr2, size);
	
	int arr3[] = {1, 34, 3, 98, 9, 76, 45, 4};
	size = sizeof(arr3)/sizeof(arr3[0]);
	getLargestNumber(arr3, size);

	return 0;
}
