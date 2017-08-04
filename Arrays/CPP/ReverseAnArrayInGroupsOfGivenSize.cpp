/*
Given an array, reverse every sub-array formed by consecutive k elements.

        Input: 
        arr = [1, 2, 3, 4, 5, 6, 7, 8, 9]
        k = 3
        Output:  
        [3, 2, 1, 6, 5, 4, 9, 8, 7]
        
        Input: 
        arr = [1, 2, 3, 4, 5, 6, 7, 8]
        k = 5
        Output:  
        [5, 4, 3, 2, 1, 8, 7, 6]
        
        Input: 
        arr = [1, 2, 3, 4, 5, 6]
        k = 1
        Output:  
        [1, 2, 3, 4, 5, 6]
        
        Input: 
        arr = [1, 2, 3, 4, 5, 6, 7, 8]
        k = 10
        Output:  
        [8, 7, 6, 5, 4, 3, 2, 1]
*/

#include <iostream>
using namespace std;

void reverse(int arr[], int i, int j) {
    while (i < j)
        swap(arr[i++], arr[j--]);
}

void reverseInGroups(int arr[], int n, int k) {
    int i = 0;
    if (k < n) {
        while (i < n) {
            if (i+k-1 < n) {
                reverse(arr, i, i+k-1);
                i += k;
            }
            else {
                reverse(arr, i, n-1);
                break;
            }
        }
    }
}
void printArray(int a[], int n) {
    for (int i = 0; i < n; i++)
        cout << a[i] << " ";
    cout <<"\n";
}
int main() {
	int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	int n = sizeof(arr)/sizeof(arr[0]);
	int k = 4;
	
	cout << "The original array is : ";
	printArray(arr, n);
	reverseInGroups(arr, n , k);
	cout << "The reversed array is :";
	printArray(arr, n);
	return 0;
}
