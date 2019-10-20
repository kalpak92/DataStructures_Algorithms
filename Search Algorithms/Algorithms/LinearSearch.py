# Linearly search x in arr[]
# If x is present then return True
# else return False

__author__ = "Kalpak Seal"

def linear_search(arr, x):
    for i in range(len(arr)):
        if arr[i] == x:
            return True

    return False

if __name__ == "__main__":
    print("Enter the numbers of the list")
    arr = [int(x) for x in input().split()]

    print("Enter the number to be searched")
    x = int(input())

    print(linear_search(arr, x))
