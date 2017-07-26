/*
Equilibrium index of an array is an index such that 
the sum of elements at lower indexes is equal to the sum of elements at higher indexes.

For example, in array A:
    A[0] = -7, A[1] = 1, A[2] = 5, A[3] = 2, A[4] = -4, A[5] = 3, A[6]=0
    
    3 is an equilibrium index, because:
    A[0] + A[1] + A[2] = A[4] + A[5] + A[6]
    
    6 is also an equilibrium index, 
    because sum of zero elements is zero, i.e., A[0] + A[1] + A[2] + A[3] + A[4] + A[5]=0
    
    7 is not an equilibrium index, because it is not a valid index of array A.

Write a function int equilibrium(int[] arr, int n); that given a sequence arr[] of size n, 
returns an equilibrium index (if any) or -1 if no equilibrium indexes exist.

Time Complexity: O(n)
*/
#include <iostream>
using namespace std;

int get_equilibrium_point(int a[], int n) {
    int sum = 0;
    int leftSum = 0;
    
    for(int i = 0; i < n; i++)
        sum += a[i];
    
    for (int i = 0; i < n; i++) {
        sum -= a[i];
        
        if (sum == leftSum)
            return i;
            
        leftSum += a[i];
    }
    
    return -1;
}
int main() {
	int arr[] = {-7, 1, 5, 2, -4, 3, 0};
	int size = sizeof(arr)/sizeof(arr[0]);
	
	cout << "The equilibrium point of the array is : "<< get_equilibrium_point(arr,size) << endl;
	return 0;
}
