"""
  Performs binary search on an array
    with the given item and returns True or
    False.
    
    >>> search([5, 4, 1, 6, 2, 3, 9, 7], 2)
    True
    
    >>> search([5, 4, 1, 6, 2, 3, 9, 7], 8)
    False
"""

__author__ = "Kalpak Seal"

def binary_search(arr, x):
    arr = sorted(arr)

    first = 0
    last = len(arr) - 1
    found = False

    while first <= last and not found:
        mid = first + (last - first) // 2

        if arr[mid] == x:
            found = True
            break
        else:
            if x < arr[mid]:
                last = mid - 1
            elif x > arr[mid]:
                first = mid + 1

    return  found

if __name__ == "__main__":
    arr = [int(x) for x in input("Enter the integers of the list ").split()]
    x = int(input("Enter the number to be searched "))

    print(binary_search(arr, x))
