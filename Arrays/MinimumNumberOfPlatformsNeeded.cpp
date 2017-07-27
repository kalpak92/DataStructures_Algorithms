/*
Given arrival and departure times of all trains that reach a railway station, 
find the minimum number of platforms required for the railway station so that no train waits.
We are given two arrays which represent arrival and departure times of trains that stop.

Input:  arr[]  = {9:00,  9:40, 9:50,  11:00, 15:00, 18:00}
        dep[]  = {9:10, 12:00, 11:20, 11:30, 19:00, 20:00}
Output: 3
        There are at-most three trains at a time (time between 11:00 to 11:20)
*/

#include <iostream>
#include <algorithm>
using namespace std;

int getMinimumPlatforms(int arr[], int dep[], int n) {
    sort(arr, arr+n);
    sort(dep, dep+n);
    
    int platform_needed = 1, result = 1;
    int i = 1, j = 0;
    
    while(i < n && j < n) {
        if (arr[i] < dep[j]) {
            platform_needed ++;
            i++;
            
            if (platform_needed > result)
                result = platform_needed;
        }
        else {
            platform_needed --;
            j++;
        }
    }
    
    return result;
}

int main() {
	int arr[] = {900, 940, 950, 1100, 1500, 1800};
    int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
    int n = sizeof(arr)/sizeof(arr[0]);
    cout << "Minimum Number of Platforms Required = " << getMinimumPlatforms(arr, dep, n) << endl;
	return 0;
}
