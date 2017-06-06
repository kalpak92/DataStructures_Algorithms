__author__ = 'Kalpak Seal'
'''
Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal, where a move is incrementing n - 1 elements by 1.
Example:
Input:
[1,2,3]

Output:
3

Explanation:
Only three moves are needed (remember each move increments two elements):

[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
'''

'''
ALGORITHM:

This is an interesting problem that can be solved more simplistically than the problem suggests. 
Don't try to follow the strategy implied by the problem description - 
it is misleading and will make your code convoluted and inefficient. Here are few insights that will lead to a 3-liner solution:

Insight 1: when the problem says "incrementing n-1 elements by 1", notice that this is the same as saying "decrementing 1 element by 1". If you're increasing n-1 elements by 1 (meaning increasing all but one element), it is the same as decreasing that one element by 1. This will make the solution much easier.

Insight 2: given a certain element A, and using "Insight 1", in order for all the elements to be the same at the end, inevitably we'll have to transform A into the minimum element in the array. Hence, for a given element A, there will be at least A - Min(Array) moves to get to the solution. In fact the solution will then be the summation of Ai - Min(Array) for every Ai in the array.

Insight 3: given "Insight 2", we can do some math to land at the final formula to solve the problem in linear time:

Solution = A1 - Min(Array) + A2 - Min(Array) + ... + An - Min(Array)
Solution = (A1 + A2 + A3 + ... + An) - n*Min(Array)
Solution = Sum(Array) - n*Min(Array)

'''
import sys


def get_minimum_moves(arr):
    sum = 0
    min = sys.maxsize

    for i in range(0, len(arr)):
        sum += arr[i]
        if min > arr[i]:
            min = arr[i]

    return (sum - len(arr) * min)


def main():
    arr = [int(x) for x in input('Enter the array elements ').split()]
    print(get_minimum_moves(arr))


if __name__ == '__main__':
    main()