/*
Pythagorean Triplet in an array
Given an array of integers, write a function that returns true if there is a triplet (a, b, c) 
that satisfies a^2 + b^2 = c^2.

Example:
    Input: arr[] = {3, 1, 4, 6, 5}
    Output: True
    There is a Pythagorean triplet (3, 4, 5).
    
    Input: arr[] = {10, 4, 6, 12, 5}
    Output: False
    There is no Pythagorean triplet.

Time Complexity: O(n)
*/

#include <iostream>
#include <algorithm>
using namespace std;

bool isPythagoreanTriplet(int arr[], int n) {
    
    //Square all the elements
    for (int i = 0; i < n; i++) {
        arr[i] = arr[i] * arr[i];
    }
    
    sort(arr, arr + n);
    
    for (int i = n-1; i >=2; i--) {
        int l = 0;
        int r = i -1;
        
        while (l < r) {
            if (arr[l] + arr[r] == arr[i])
                return true;
            
            (arr[l] + arr[r] < arr[i]) ? l++ : r--;
        }
    }
    return false;
}

int main() {
	int arr[] = {3, 1, 4, 6, 5};
    int arr_size = sizeof(arr)/sizeof(arr[0]);
    isPythagoreanTriplet(arr, arr_size)? cout << "Yes": cout << "No";
	return 0;
}
