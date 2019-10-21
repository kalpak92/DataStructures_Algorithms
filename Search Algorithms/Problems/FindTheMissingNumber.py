__author__='Kalpak Seal'

def find_missing_number(arr):
    n = len(arr)
    x = 0
    y = 0

    for i in range(1, n+2):
        x = x ^ i
    for i in range(0, n):
        y = y ^ arr[i]

    print("The missing number is: ", x^y)

if __name__ == '__main__':
    arr = [int(x) for x in input("Enter the number").split()]
    print (find_missing_number(arr))
