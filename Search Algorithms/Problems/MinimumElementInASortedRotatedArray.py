__author__="Kalpak Seal"

def find_minimum(arr, first, last):
        if (last < first):
                #print("1st Condition: " + str(arr[0]))
                return arr[0]

        if (last == first):
                #print ("2nd condition: " + str(arr[first]))
                return arr[first]

        mid = first + ((last - first) // 2)

        if (mid < last and arr[mid + 1] < arr[mid]):
                print (arr[mid], arr[mid + 1])
                return arr[mid + 1]

        if (mid > first and arr[mid] < arr[mid - 1]):
                #print (arr[mid - 1], arr[mid])
                return arr[mid]

        if (arr[last] > arr[mid]):
                #print (first, mid -1 )
                return find_minimum(arr, first, mid - 1)
        else:
                #print (mid + 1, last)
                return find_minimum(arr, mid + 1, last)

if __name__ == '__main__':
        arr = [int(x) for x in input("Enter the elements to be searched from: ").split()]
        first = 0
        last = len(arr) - 1

        print ("The Minimum Element is: " + str(find_minimum(arr, first, last)))
