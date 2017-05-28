__author__ = 'Kalpak Seal'

'''
We can search an element in one pass of Binary Search. The idea is to search

1) Find middle point mid = (l + h)/2
2) If key is present at middle point, return mid.
3) Else If arr[l..mid] is sorted
    a) If key to be searched lies in range from arr[l]
       to arr[mid], recur for arr[l..mid].
    b) Else recur for arr[mid+1..r]
4) Else (arr[mid+1..r] must be sorted)
    a) If key to be searched lies in range from arr[mid+1]
       to arr[r], recur for arr[mid+1..r].
    b) Else recur for arr[l..mid] We can search an element in one pass of Binary Search. The idea is to search

1) Find middle point mid = (l + h)/2
2) If key is present at middle point, return mid.
3) Else If arr[l..mid] is sorted
    a) If key to be searched lies in range from arr[l]
       to arr[mid], recur for arr[l..mid].
    b) Else recur for arr[mid+1..r]
4) Else (arr[mid+1..r] must be sorted)
    a) If key to be searched lies in range from arr[mid+1]
       to arr[r], recur for arr[mid+1..r].
    b) Else recur for arr[l..mid] 
'''
def search_an_element_utility(arr, left, right, key):
    if left > right:
        return -1

    mid = left + (right - left)//2
    if arr[mid] == key:
        return mid

    if arr[left] <= arr[mid]:
        if key >= arr[left] and key <= arr[mid]:
            return search_an_element_utility(arr, left, mid - 1, key)
        return search_an_element_utility(arr, mid + 1, right, key)

    else:
        if key >= arr[mid] and key <= arr[right]:
            return search_an_element_utility(arr, mid + 1, right, key)
        return search_an_element_utility(arr, left, mid - 1, key)

def search_an_element(arr, key):
    index = search_an_element_utility(arr, 0, len(arr) - 1, key)

    return index

def main():
    arr = [int(x) for x in input('Enter the elements ').split()]
    key = int(input('Enter the element to be searched for'))

    print (search_an_element(arr, key))

if __name__ == '__main__':
    main()
