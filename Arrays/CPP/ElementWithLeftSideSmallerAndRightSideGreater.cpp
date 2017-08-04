/*
Find the element before which all the elements are smaller than it, and after which all are greater

Examples:
    Input:   arr[] = {5, 1, 4, 3, 6, 8, 10, 7, 9};
    Output:  Index of element is 4
    All elements on left of arr[4] are smaller than it and all elements on right are greater.
     
    Input:   arr[] = {5, 1, 4, 4};
    Output:  Index of element is -1

Time complexity: O(n)
*/

#include <iostream>
using namespace std;

void findElementWithElementsSmallerOnLeftAndGreaterOnRight(int a[], int n) {
    if (n < 3) {
        cout << "Number of elements in array is less than 3 \n";
        return;
    }
    else {
        int highestOnLeft = a[0];
        int answer = -1;
        bool isAnswerFound = false;
        
        int i = 1;
        while (i < n -1) {
            if (a[i] >= highestOnLeft && a[i] <= a[i+1]) {
                isAnswerFound = true;
                answer = a[i];
                
                while (answer <= a[i+1] && i < n-1) {
                    if(a[i] >= highestOnLeft) {
                        highestOnLeft = a[i];
                    }
                    i++;
                }
            }
            else {
                isAnswerFound = false;
                answer = -1;
                
                if (a[i] >= highestOnLeft)
                    highestOnLeft = a[i];
                    
                i++;
            }
        }
        
        if (isAnswerFound)
            cout << "Element is " << answer << ".\n";
        else
            cout << "No such element exists. \n";
    }
}

int main() {
	int arr[] = {1,11,8,7,23,4,33,56,45,99};
	int size = sizeof(arr)/sizeof(arr[0]);
	findElementWithElementsSmallerOnLeftAndGreaterOnRight(arr, size);
	return 0;
}
