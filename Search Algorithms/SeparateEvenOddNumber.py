__author__='Kalpak Seal'
def separate_even_and_odd(arr):
    left = 0
    right = len(arr) - 1

    while left < right:
        while arr[left]%2 == 0 and left < right:
            left += 1
        while arr[right]%2 == 1 and left < right:
            right -= 1
        if (left < right):
            arr[left], arr[right] = arr[right], arr[left]
            left += 1
            right -= 1
    return arr

if __name__ == '__main__':
    arr = [int(x) for x in input("Enter the list of numbers: ").split()]
    print(separate_even_and_odd(arr))