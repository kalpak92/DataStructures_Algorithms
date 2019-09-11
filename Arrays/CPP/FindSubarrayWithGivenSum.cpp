/*
Given an unsorted array of nonnegative integers, find a continous subarray which adds to a given number.

Examples:
      Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
      Ouptut: Sum found between indexes 2 and 4

      Input: arr[] = {1, 4, 0, 0, 3, 10, 5}, sum = 7
      Ouptut: Sum found between indexes 1 and 4

      Input: arr[] = {1, 4}, sum = 0
      Output: No subarray found

There may be more than one subarrays with sum as the given sum. The following solutions print first such subarray.
*/
#include <iostream>
using namespace std;

void subArrayWithGivenSum(int a[], int size, int sum) {
    int start = 0;
    int curr_sum = 0;
    int i;
    
    for (i = 0; i < size; i++) {
        curr_sum += a[i];
        if (curr_sum == sum)
            break;
        else if (curr_sum > sum) {
            while (curr_sum > sum)
                curr_sum -= a[start++];
                
                if (curr_sum == sum)
                    break;
        }
    }
    
    if (curr_sum == sum)
        cout << "The sub array exists between "<< start << " and " << i <<".\n";
    else
        cout << "No Sub Array Found. \n";

    return;
}

int main() {
	int arr[] = {15, 2, 4, 8, 9, 5, 10, 23};
	int size = sizeof(arr)/sizeof(arr[0]);
	int sum = 23;
	subArrayWithGivenSum(arr, size, sum);
	return 0;

}
