__author__ = 'Kalpak Seal'

'''
Given an array A[] of n numbers and another number x, 
determine whether or not there exist two elements in S whose sum is exactly x. 
'''

'''
ALGORITHM

Let sum be the given sum and A[] be the array in which we need to find pair.

1) Initialize Binary Hash Map M[] = {0, 0, ...}
2) Do following for each element A[i] in A[]
   (a)	If M[x - A[i]] is set then print the pair (A[i], x - A[i])
   (b)	Set M[A[i]]
   
'''
import sys

def get_pairs(arr, x):
    max = 100000
    bin_map = [0]*max

    for i in range(len(arr)):
        temp = x - arr[i]
        if temp >= 0 and bin_map[temp] == 1:
            return arr[i], temp

        bin_map[arr[i]] = 1

def main():
    arr = [int(x) for x in input('Enter the numbers').split()]
    x = int(input('Enter the sum to be searched for '))

    print (get_pairs(arr, x))

if __name__ == '__main__':
    main()

