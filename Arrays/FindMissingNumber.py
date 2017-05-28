__author__ = 'Kalpak Seal'

'''
Given a list of n-1 integers and these integers are in the range of 1 to n. 
There are no duplicates in list. One of the integers is missing in the list.
'''

'''
ALGORITHM:
    1) XOR all the array elements, let the result of XOR be X1.
    2) XOR all numbers from 1 to n, let XOR be X2.
    3) XOR of X1 and X2 gives the missing number.
'''

def get_missing_number(arr):
    x1 = arr[0]
    x2 = 1

    for i in range(1, len(arr)):
        x1 ^= arr[i]

    for i in range(2, len(arr)+2):
        x2 ^= i

    return x1^x2

def main():
    arr = [int(x) for x in input('Enter the numbers ').split()]
    print(get_missing_number(arr))

if __name__ == '__main__':
    main()