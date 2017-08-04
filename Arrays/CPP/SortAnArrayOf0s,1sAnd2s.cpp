/*
Given an array A[] consisting 0s, 1s and 2s, write a function that sorts A[]. 

Example
    Input = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
    Output = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2}
    
Time Complexity: O(n)
*/

#include <iostream>
using namespace std;

void swap(int *a, int *b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

void sortArray012(int a[], int n) {
    int low = 0;
    int high = n-1;
    int mid = 0;
    
    while (mid <= high) {
        switch(a[mid]) {
            case 0:
                swap(a[low], a[mid]);
                low++;
                mid++;
                break;
            case 1:
                mid++;
                break;
            case 2:
                swap(a[mid], a[high]);
                high--;
                break;
        }
    }
}

void printArray(int a[], int size) {
    cout <<"The array elements are \t";
    for (int i = 0; i < size; i++) {
        cout<< a[i] << " "; 
    }
    cout <<"\n";
}

int main() {
	int arr[] = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
    int arr_size = sizeof(arr)/sizeof(arr[0]);
    
    cout <<"The original array is : \n";
    printArray(arr, arr_size);
    
    sortArray012(arr, arr_size);
    
    cout << "The sorted array is \n";
    printArray(arr, arr_size);
	
	return 0;
}
