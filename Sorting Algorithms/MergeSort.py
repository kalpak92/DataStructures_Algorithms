__author__='Kalpak Seal'

def merge(arr, left, mid, right):
    n1 = mid - left + 1
    n2 = right - mid

    #Create two temporary lists
    L = [0] * n1
    R = [0] * n2

    #Copy data to temp arrays L[] R[]
    for i in range(0, n1):
        L[i] = arr[left + i]
        #print (L)

    for j in range(0, n2):
        R[j] = arr[mid + 1 + j]
        #print(R)
    #Merge two arrays back to arr
    i = 0
    j = 0
    k = left

    while i < n1 and j < n2:
        if L[i] <= R[j]:
            arr[k] = L[i]
            i += 1
        else:
            arr[k] = R[j]
            j += 1
        k += 1

    #Copy remaining elements from L[] or R[] if any
    while i < n1:
        arr[k] = L[i]
        i += 1
        k += 1

    while j < n2:
        arr[k] = R[j]
        j += 1
        k += 1


def merge_sort(arr, left, right):
    if left < right:
        mid = left + ((right - left) // 2)

        merge_sort(arr, left, mid)
        merge_sort(arr, mid+1, right)
        merge(arr, left, mid, right)

if __name__ == '__main__':
    arr = [int(x) for x in input("Enter the numbers: ").split()]
    merge_sort(arr, 0, len(arr) - 1)
    print ("The sorted list is: ", arr)