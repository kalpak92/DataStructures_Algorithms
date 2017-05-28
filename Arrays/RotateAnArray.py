__author__ = 'Kalpak Seal'
'''
Input:  arr[] = [1, 2, 3, 4, 5, 6, 7]
            d = 2
Output: arr[] = [3, 4, 5, 6, 7, 1, 2] 

Algorithm:

rotate(arr[], d, n)
  reverse(arr[], 1, d) ;
  reverse(arr[], d + 1, n);
  reverse(arr[], l, n);
'''
def reverse_array(arr, start, end):
    while start < end:
        arr[start], arr[end] = arr[end], arr[start]
        start += 1
        end -= 1

def rotate_an_array(arr, key):
    n = len(arr)

    reverse_array(arr, 0, key-1)
    reverse_array(arr, key, n-1)
    reverse_array(arr, 0, n-1)

def main():
    arr = [int(x) for x in input('Enter the elements in the array ').split()]
    key = int(input('Enter the value to be rotated with '))

    rotate_an_array(arr, key)
    print (arr)

if __name__ == '__main__':
    main()