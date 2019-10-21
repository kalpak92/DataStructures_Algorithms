__author_='Kalpak Seal'
import math

def check_for_duplicates_negation_technique(arr):
    arr.sort()

    for i in range(0, len(arr)):
        if (arr[abs(arr[i])] < 0):
            print("Duplicates exist:", arr[i])
            return
        else:
            arr[arr[i]] = -arr[arr[i]]
            #print (arr)

    print("No Duplicates in a given array")

if __name__== '__main__':
    arr = [int(x) for x in input("Enter the elements: ").split()]
    check_for_duplicates_negation_technique(arr)