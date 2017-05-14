__author__='Kalpak Seal'

def selection_sort(arr):
    n = len(arr)

    for i in range(n):
        least = i
        for j in range(i+1, n):
            if arr[least] > arr[j]:
                least = j
        arr[i], arr[least] = arr[least], arr[i]

    return  arr

if __name__=='__main__':
    arr = [int(x) for x in input("Enter the list of numbers to be sorted").split()]
    print (selection_sort(arr))