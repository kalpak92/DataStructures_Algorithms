__author__='Kalpak Seal'

def improved_bubble_sort(arr):
    start_time = time.clock()
    n = len (arr)
    swapped = False

    for i in range(0,n):
        for j in range(0,n-i-1):
            if arr[j] > arr[j+1]:
                arr[j], arr[j+1] = arr[j+1], arr[j]
                swapped = True

        if swapped is False:
            break
    print(time.clock() - start_time)
    return arr

if __name__=='__main__':
    import time
    #start_time = time.clock()
    arr = [int(x) for x in input("Enter the list of numbers to be sorted").split()]
    print (improved_bubble_sort(arr))
    #print("--- %s seconds ---" % (time.clock() - start_time))