__author__='Kalpak Seal'

def bubble_sort(arr):
    n = len (arr)

    for i in range(0,n):
        for j in range(0,n-i-1):
            if arr[j] > arr[j+1]:
                arr[j], arr[j+1] = arr[j+1], arr[j]
    return arr

if __name__=='__main__':
    arr = [int(x) for x in input("Enter the list of numbers to be sorted").split()]
    print (bubble_sort(arr))
