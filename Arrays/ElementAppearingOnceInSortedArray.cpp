/*
Find the element that appears once in a sorted array.

Given a sorted array in which all elements appear twice (one after one) and one element appears only once.

Example:
    Input:   arr[] = {1, 1, 3, 3, 4, 5, 5, 7, 7, 8, 8}
    Output:  4
    
    Input:   arr[] = {1, 1, 3, 3, 4, 4, 5, 5, 7, 7, 8}
    Output:  8

Time complexity: O(log n)
*/

#include <iostream>
using namespace std;

void searchElementThatOccursOnce(int arr[], int low, int high) {
    if (low > high) {
        cout << "There is no such element \n";
        return;
    }
    if (low == high) {
        cout << "The required element is " << arr[low] <<".\n";
        return;
    }
    
    int mid = low + (high - low)/2;
    
    if (mid % 2 == 0) {
        if (arr[mid] == arr[mid+1])
            searchElementThatOccursOnce(arr, mid+2, high);
        else
            searchElementThatOccursOnce(arr, low, mid);
    }
    else {
        if (arr[mid] == arr[mid-1])
            searchElementThatOccursOnce(arr, mid+1, high);
        else
            searchElementThatOccursOnce(arr, low, mid-1);
    }
}

int main() {
    int arr[] = {1, 1, 2, 2, 4, 4, 5, 5, 6};
    int len = sizeof(arr)/sizeof(arr[0]);
    searchElementThatOccursOnce(arr, 0, len-1);
	return 0;
}
