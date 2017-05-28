__author__ = 'Kalpak Seal'
'''
An element is leader if it is greater than all the elements to its right side. And the rightmost element is always a leader. 
For example int the array {16, 17, 4, 3, 5, 2}, leaders are 17, 5 and 2.
'''

def print_leaders(arr):
    n = len(arr)
    max_from_right = arr[n - 1]
    print (max_from_right, end=' ')

    for i in range(n-2, -1, -1):
        if max_from_right < arr[i]:
            print(arr[i], end=' ')
            max_from_right = arr[i]

def main():
    arr = [int(x) for x in input('Enter the elements ').split()]
    print_leaders(arr)

if __name__ == '__main__':
    main()