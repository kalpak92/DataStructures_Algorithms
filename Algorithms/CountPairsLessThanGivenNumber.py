__author__ = 'Kalpak Seal'
'''
Given a sorted integer array and number x, the task is to count pairs in array whose sum is less than x.

Examples:

Input  : arr[] = {1, 3, 7, 9, 10, 11}
         x = 7
Output : 1
There is only one pair (1, 3)

Input  : arr[] = {1, 2, 3, 4, 5, 6, 7, 8}
         x = 7
Output : 6
Pairs are (1, 2), (1, 3), (1, 4), (1, 5)
          (2, 3) and (2, 4)  
'''


def count_pairs_less_than_x(arr, k):
    left = 0
    right = len(arr) - 1
    result = 0

    while left < right:
        if arr[left] + arr[right] < k:
            result += right - left
            left += 1
        else:
            right -= 1

    return result


def main():
    arr = [int(x) for x in input().split()]
    k = int(input())

    print(count_pairs_less_than_x(arr, k))


if __name__ == '__main__':
    main()