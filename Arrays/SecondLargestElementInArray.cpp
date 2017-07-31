/*
Find Second largest element in an array.
Given an array of integers, our task is to write a program that efficiently finds the second largest element present in the array.

Example:
    Input : arr[] = {12, 35, 1, 10, 34, 1}
    Output : The second largest element is 34.
    
    Input : arr[] = {10, 5, 10}
    Output : The second largest element is 5.
    
    Input : arr[] = {10, 10, 10}
    Output : The second largest does not exist.
*/

#include <iostream>
#include <limits.h>
using namespace std;

void findSecondLargest(int a[], int n) {
    if (n < 2) {
        cout << "Invalid Input for this problem \n";
        return;
    }
        
    int first = INT_MIN;
    int second = INT_MIN;
    
    for (int i = 0; i < n; i++) {
        if (a[i] > first) {
            second = first;
            first = a[i];
        }
        else if (a[i] > second && a[i] != first) {
            second = a[i];
        }
    }
    
    if (second == INT_MIN)
        cout << "There is no Second Largest Element in the array. \n";
    else
        printf("The Largest element is %d \nThe Second largest element is %d .\n",first, second);
    
}
int main() {
	int arr[] = {12, 35, 1, 10, 34, 1};
	int size = sizeof(arr)/sizeof(arr[0]);
	findSecondLargest(arr, size);
	
    int a[] = {1, 1, 1, 1, 1};
	size = sizeof(a)/sizeof(a[0]);
	findSecondLargest(a, size);

	return 0;
}
