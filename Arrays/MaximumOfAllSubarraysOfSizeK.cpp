/*
Given an array and an integer k, find the maximum for each and every contiguous subarray of size k.

Examples:

        Input :
        arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}
        k = 3
        Output :
        3 3 4 5 5 5 6
        
        Input :
        arr[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13}
        k = 4
        Output :
        10 10 10 15 15 90 90

Time Complexity: O(n)
*/
#include <iostream>
#include <deque>
using namespace std;

void maxSubArrayK(int arr[], int n, int k) {
    deque<int> x(k);
    int i = 0;
    
    for(i = 0; i < k; i++) {
        while((!x.empty()) && arr[i] >= arr[x.back()])
            x.pop_back();
        
        x.push_back(i);
    }
    
    for (; i < n; i++) {
        cout << arr[x.front()] << " ";
        
        while ((!x.empty()) && x.front() <= i - k)
            x.pop_front();
        
        while ((!x.empty()) && arr[i] >= arr[x.back()])
            x.pop_back();
        
        x.push_back(i);
    }
    
    cout << arr[x.front()] << "\n";
}
int main() {
	int arr[] = {12, 1, 78, 90, 57, 89, 56};
    int n = sizeof(arr)/sizeof(arr[0]);
    int k = 3;
    maxSubArrayK(arr, n, k);
    
    int a[] = {5, 3, 4, 1, 6, 2, 2, 4, 3, 1, 5};
    n = sizeof(a)/sizeof(a[0]);
    k = 3;
    maxSubArrayK(a, n, k);
	return 0;
}
