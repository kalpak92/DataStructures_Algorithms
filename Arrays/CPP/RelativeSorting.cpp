/*
        RELATIVE SORTING
Given two arrays A1[] and A2[], sort A1 in such a way that the relative order among the elements will be 
same as those are in A2. For the elements not present in A2, append them at last in sorted order.

    Input: A1[] = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8}
           A2[] = {2, 1, 8, 3}
    Output: A1[] = {2, 2, 1, 1, 8, 8, 3, 5, 6, 7, 9}
    
    The code should handle all cases like number of elements in A2[] may be more or less compared to A1[]. 
    A2[] may have some elements which may not be there in A1[] and vice versa is also possible.
    

ALGORITHM:

1. Loop through A1[], store the count of every number in a HashMap (key: number, value: count of number) .
2. Loop through A2[], check if it is present in HashMap, if so, put in output array that many times and remove the number from HashMap.
3. Sort the rest of the numbers present in HashMap and put in output array.

*/

#include <iostream>
#include <map>
using namespace std;

void relativeSorting(int a1[], int n1, int a2[], int n2) {
    map<int, int> mp;
    
    for (int i=0; i < n1; i++) {
        mp[a1[i]]++;
    }
    
    for (int i=0; i < n2; i++) {
        if (mp.find(a2[i]) != mp.end()) {
            
            for (int j=0; j<mp[a2[i]]; j++) {
                cout << a2[i] << " ";
            }
            
            mp.erase(a2[i]);
        }
    }
    
    map<int, int> :: iterator it;
    
    for(it=mp.begin(); it!=mp.end(); it++) {
        for (int i=0; i<it->second; i++){
            cout << it->first << " ";
        }
    }
    
    cout << "\n";
}

int main() {
	int arr1[] = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8 , 9, 9, 9};
	int arr2[] = {2, 1, 8, 3};
	
	int size1 = sizeof(arr1)/sizeof(arr1[0]);
	int size2 = sizeof(arr2)/sizeof(arr2[0]);
	
	relativeSorting(arr1, size1, arr2, size2);
	return 0;
}
