/*
Find the sum of contiguous subarray within a one-dimensional array of numbers which has the largest sum.

Algorithm:

        Initialize:
            max_so_far = 0
            max_ending_here = 0
        
        Loop for each element of the array
          (a) max_ending_here = max_ending_here + a[i]
          (b) if(max_ending_here < 0)
                    max_ending_here = 0
          (c) if(max_so_far < max_ending_here)
                    max_so_far = max_ending_here
        return max_so_far


Time Complexity: O(n)
*/

#include <iostream>
using namespace std;

int maximumSubArraySum(int arr[], int size) {
    int max_so_far = arr[0];
    int max_ending_here = arr[0];
    
    for (int i = 1; i < size; i++) {
        max_ending_here = max(arr[i], max_ending_here + arr[i]);
        max_so_far = max(max_so_far, max_ending_here);
    }
    
    return max_so_far;
}

int main() {
    //int a[] =  {-2, -3, -4, -9, -2, -3, -5, -3};
    int a[] =  {-2, -3, 4, -1, -2, 1, 5, -3};
    int n = sizeof(a)/sizeof(a[0]);
    int max_sum = maximumSubArraySum(a, n);
    cout << "Maximum contiguous sum is " << max_sum;
    return 0;	
}
