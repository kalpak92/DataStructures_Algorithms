__author__='Kalpak Seal'

def insertion_sort(arr):
    n = len(arr)

    for i in range(1, n):
        key = arr[i]

        j = i-1
        while j >= 0 and key < arr[j]:
            arr[j+1] = arr[j]
            j -= 1

        arr[j+1] = key
    return arr

if __name__== '__main__':
    arr = [int(x) for x in input("Enter the list of numbers to be sorted").split()]
    print(insertion_sort(arr))