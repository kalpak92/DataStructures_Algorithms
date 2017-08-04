/*
Given an unsorted array of nonnegative integers, find a continous subarray which adds to a given number.
Examples:
        Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
        Ouptut: Sum found between indexes 2 and 4

        Input: arr[] = {10, 2, -2, -20, 10}, sum = -10
        Ouptut: Sum found between indexes 0 to 3

        Input: arr[] = {-10, 0, 2, -2, -20, 10}, sum = 20
        Ouptut: No subarray with given sum exists
There may be more than one subarrays with sum as the given sum. The following solutions print first such subarray.
*/
#include <iostream>
#include <unordered_map>
using namespace std;

void subArraySum(int a[], int n, int sum) {
    unordered_map<int, int> map;
    
    int curr_sum = 0;
    
    for(int i =0; i < n; i++) {
        curr_sum += a[i];
        
        if (curr_sum == sum) {
            cout << "Sum found between indexes 0 to " << i << ".\n";
            return;
        }
        
        if (map.find(curr_sum - sum) != map.end()) {
            cout << "Sum found between indexes " << map[curr_sum - sum] + 1 << " to " << i <<endl;
            return;
        }
        map[curr_sum] = i;
    }
    
    cout << "No subarray with given sum exists";
}

int main() {
	int arr[] = {10, 2, -2, -20, 10};
	int size = sizeof(arr)/sizeof(arr[0]);
	int sum = -2;
	subArraySum(arr, size, sum);
	return 0;
}
