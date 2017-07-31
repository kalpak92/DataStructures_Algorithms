/*
Find the smallest and second smallest elements in an array.

Example:

    Input:  arr[] = {12, 13, 1, 10, 34, 1}
    Output: The smallest element is 1 and 
            second Smallest element is 10

Time Complexity: O(n)
*/

#include <iostream>
#include <limits.h>
using namespace std;

void findSecondSmallest(int a[], int n) {
    if (n < 2) {
        cout << "Invalid Input for this problem \n";
        return;
    }
        
    int first = INT_MAX;
    int second = INT_MAX;
    
    for (int i = 0; i < n; i++) {
        if (a[i] < first) {
            second = first;
            first = a[i];
        }
        else if (a[i] < second && a[i] != first) {
            second = a[i];
        }
    }
    
    if (second == INT_MAX)
        cout << "There is no Second Smallest Element in the array. \n";
    else
        printf("The Smallest element is %d \nThe Second smallest element is %d .\n",first, second);
    
}
int main() {
	int arr[] = {12, 35, 1, 10, 34, 1};
	int size = sizeof(arr)/sizeof(arr[0]);
	findSecondSmallest(arr, size);
	return 0;
}
