__author__ = 'Kalpak Seal'

'''
SORT-AND-COUNT (L) 
IF list L has one element
 RETURN (0, L).
DIVIDE the list into two halves A and B.
(rA , A) ← SORT-AND-COUNT(A).
(rB , B) ← SORT-AND-COUNT(B).
(rAB , L') ← MERGE-AND-COUNT(A, B).
RETURN (rA + rB + rAB , L').
'''
def count_inversions(arr):
    return get_inversion_count(arr)[0]

def get_inversion_count(arr):
    if len(arr) <= 1:
        return 0, arr

    mid = len(arr)//2

    a, left = get_inversion_count(arr[:mid])
    print ("left", a, left)
    b, right = get_inversion_count(arr[mid:])
    print ("right", b, right)
    c, result = merge_count_split_inversion(left, right)
    print ("result", c, result)
    return (a + b + c), result

def merge_count_split_inversion(left, right):
    result = []
    count = 0
    i, j = 0, 0

    while i < len(left) and j < len(right):
        if left[i] <= right[j]:
            result.append(left[i])
            i += 1
        else:
            result.append(right[j])
            count += len(left) - i
            j += 1

    result += left[i:]
    result += right[j:]

    return count, result

if __name__ == '__main__':
    input_array_1 = []  # 0
    input_array_2 = [1]  # 0
    input_array_3 = [1, 5]  # 0
    input_array_4 = [4, 1]  # 1
    input_array_5 = [4, 1, 2, 3, 9]  # 3
    input_array_6 = [4, 1, 3, 2, 9, 5]  # 5
    input_array_7 = [4, 1, 3, 2, 9, 1]  # 8

    print(count_inversions(input_array_1))
    print(count_inversions(input_array_2))
    print(count_inversions(input_array_3))
    print(count_inversions(input_array_4))
    print(count_inversions(input_array_5))
    print(count_inversions(input_array_6))
    print(count_inversions(input_array_7))
