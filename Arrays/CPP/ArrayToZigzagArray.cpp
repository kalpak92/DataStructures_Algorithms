/*
Convert array into Zig-Zag fashion
Given an array of distinct elements, rearrange the elements of array in zig-zag fashion in O(n) time. 
The converted array should be in form a < b > c < d > e < f.

Example: 
    Input:  arr[] = {4, 3, 7, 8, 6, 2, 1}
    Output: arr[] = {3, 7, 4, 8, 2, 6, 1}
    
    Input:  arr[] =  {1, 4, 3, 2}
    Output: arr[] =  {1, 4, 2, 3}
*/

#include <iostream>
using namespace std;

void zigzag(int arr[], int n) {
    bool flag = true;
    
    for (int i = 0; i < n-1; i++) {
        if (flag) {
            if (arr[i] > arr[i+1])
                swap(arr[i], arr[i+1]);
        }
        
        else {
            if (arr[i] < arr[i+1])
                swap(arr[i], arr[i+1]);
        }
        
        flag = !flag;
    }
}

void printArray(int a[], int n) {
    for (int i = 0; i < n; i++)
        cout << a[i] << " ";
    cout <<"\n";
}

int main() {
	int arr[] = {4, 3, 7, 8, 6, 2, 1};
	int size = sizeof(arr)/sizeof(arr[0]);
	cout << "The original array is : ";
	printArray(arr, size);
	
	zigzag(arr, size);
	cout<< "The zigzag array is: ";
	printArray(arr, size);
	
	int a[] = {1, 4, 3, 2};
	size = sizeof(a)/sizeof(a[0]);
	cout << "The original array is : ";
	printArray(a, size);
	
	zigzag(a, size);
	cout<< "The zigzag array is: ";
	printArray(a, size);
	return 0;
}
