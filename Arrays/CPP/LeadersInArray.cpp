/*
An element is leader if it is greater than all the elements to its right side. And the rightmost element is always a leader. 
For example int the array {16, 17, 4, 3, 5, 2}, leaders are 17, 5 and 2.
*/
#include <iostream>
using namespace std;

void printLeaders(int a[], int n) {
    int max = a[n-1];
    cout << max << " ";
    
    for (int i = n -2; i >=0; i--) {
        if (max < a[i]) {
            max = a[i];
            cout << max << " ";
        }
    }
}
int main() {
	int arr[] = {16, 17, 4, 3, 5, 2};
    int n = sizeof(arr)/sizeof(arr[0]);
    cout << "The Leaders in the array are:\t";
    printLeaders(arr, n);
	return 0;
}
