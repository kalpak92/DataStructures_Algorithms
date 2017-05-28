__author__ = 'Kalpak Seal'
'''
Majority Element: A majority element in an array A[] of size n is an element that appears 
                    more than n/2 times (and hence there is at most one such element).
'''
'''
Moore’s Voting Algorithm
This is a two step process.
1. The first step gives the element that may be majority element in the array. 
   If there is a majority element in an array, then this step will definitely return majority element, 
   otherwise it will return any other element.
   
2. Check if the element obtained from above step is majority element.
   This step is necessary as we are not always sure that element return by first step is majority element.
   
1. Finding a Candidate:
    The algorithm for first phase that works in O(n) is known as Moore’s Voting Algorithm. 
    Basic idea of the algorithm is if we cancel out each occurrence of an element e with all the other 
    elements that are different from e then e will exist till end if it is a majority element.   

    findCandidate(a[], size)
        1.  Initialize index and count of majority element
             maj_index = 0, count = 1
        2.  Loop for i = 1 to size – 1
            (a) If a[maj_index] == a[i]
                  count++
            (b) Else
                count--;
            (c) If count == 0
                  maj_index = i;
                  count = 1
        3.  Return a[maj_index]

2. Check if the element obtained in step 1 is majority

    printMajority (a[], size)
        1.  Find the candidate for majority
        2.  If candidate is majority. i.e., appears more than n/2 times.
            Print the candidate
        3.  Else
           Print "NONE"
'''
def find_candidate(arr):
    major_index = 0
    count = 1

    for i in range(1, len(arr)):
        if arr[i] == arr[major_index]:
            count += 1
        else:
            count -= 1

        if count == 0:
            major_index = i
            count = 1

    return arr[major_index]

def is_majority(arr, candidate):
    count = 0
    for i in range(len(arr)):
        if arr[i] == candidate:
            count += 1

    if count > len(arr)//2:
        return True
    else:
        return False

def get_majority_element(arr):
    candidate = find_candidate(arr)

    if is_majority(arr, candidate):
        print ("The majority element is ", candidate)
    else:
        print ("No majority element")

def main():
    arr = [int(x) for x in input('Enter the elements in the array').split()]
    get_majority_element(arr)

if __name__ == '__main__':
    main()