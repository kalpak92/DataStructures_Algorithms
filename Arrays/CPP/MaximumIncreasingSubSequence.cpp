/*
Given an array of n positive integers. 
Write a program to find the sum of maximum sum subsequence of the given array such that the integers 
in the subsequence are in increasing order.

For example, 
if input is {1, 101, 2, 3, 100, 4, 5}, then output should be 106 (1 + 2 + 3 + 100), 
if the input array is {3, 4, 5, 10}, then output should be 22 (3 + 4 + 5 + 10) and 
if the input array is {10, 5, 4, 3}, then output should be 10
*/

#include <iostream>
using namespace std;

int getMaxIncreasingSubSequence(int a[], int n) {
    int msis[n];
    int max_val = 0;
    
    for (int i = 0; i < n; i++)
        msis[i] = a[i];
    
    for (int i = 1; i < n; i++) {
        for (int j = 0; j < i; j++) {
            if (a[j] < a[i]) {
                msis[i] = max(msis[i], msis[j]+a[i]);
            }
        }
    }
    
    for (int i = 0; i < n; i++){
        if (max_val < msis[i])
            max_val = msis[i];
    }
    
    return max_val;
}

int main() {
    int arr[] = {1, 101, 2, 3, 100, 4, 5};
    int size = sizeof(arr)/sizeof(arr[0]);
    cout << "The maximum sum increasing subsequence is: " << getMaxIncreasingSubSequence(arr,size) << endl;
    return 0;
}
