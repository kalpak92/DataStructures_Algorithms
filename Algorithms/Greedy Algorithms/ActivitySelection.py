__author__ = 'Kalpak Seal'

def select_activity(start, finish):
    arr = zip(start, finish)
    arr = sorted(arr, key= lambda arr:arr[1])

    prev = 0
    i = 0

    for st, fin in arr:
        if prev <= st:
            print (arr[i], end = ' ')
            prev = fin
        i += 1
    print ()

    
if __name__ == '__main__':
    start = [1, 3, 0, 5, 8, 5]
    finish = [2, 4, 6, 7, 9, 9]

    select_activity(start, finish)

    start = [5,  1, 3, 0, 5, 8]
    finish = [9, 2, 4, 6, 7, 9]
    select_activity(start, finish)