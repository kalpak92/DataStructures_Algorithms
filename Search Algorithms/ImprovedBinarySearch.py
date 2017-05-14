__author__ = "Kalpak Seal"
'''
Theoretically we need log N + 1 comparisons in worst case. 
If we observe, we are using two comparisons per iteration except during final successful match, if any. 
In practice, comparison would be costly operation, it won’t be just primitive type comparison. 
It is more economical to minimize comparisons as that of theoretical limit.
'''
def binary_search(arr, x):
    arr = sorted(arr)

    first = 0
    last = len(arr)

    while (last - 1) > 1:
        mid = (first + (last - 1)) // 2

        if arr[mid] <= x:
            first = mid
        else:
            last = mid

    if arr[first] == x:
        return  True
    else:
        return  False

if __name__ == "__main__":
    arr = [int(x) for x in input("Enter the integers of the list ").split()]
    x = int(input("Enter the number to be searched "))

    print(binary_search(arr, x))