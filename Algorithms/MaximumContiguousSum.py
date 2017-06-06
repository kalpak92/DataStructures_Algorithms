__author__ = 'Kalpak Seal'

'''
Kadane’s Algorithm:

Initialize:
    max_so_far = 0
    max_ending_here = 0

Loop for each element of the array
  (a) max_ending_here = max_ending_here + a[i]
  (b) if(max_ending_here < 0)
            max_ending_here = 0
  (c) if(max_so_far < max_ending_here)
            max_so_far = max_ending_here
return max_so_far
'''

def maximum_subarray_sum(arr):
    max_so_far = 0
    max_ending_here = 0

    for i in range(len(arr)):
        max_ending_here += arr[i]
        if max_ending_here < 0:
            max_ending_here = 0
        elif max_so_far < max_ending_here:
            max_so_far = max_ending_here

    return max_so_far

def main():
    arr = [int(x) for x in input('Enter the elements').split()]
    print('The maximum sub-array sum is: ', maximum_subarray_sum(arr))

if __name__ == '__main__':
    main()
