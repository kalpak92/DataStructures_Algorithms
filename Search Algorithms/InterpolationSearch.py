__author__="Kalpak Seal"

def interpolation_search(arr, x):
        first = 0
        last = len(arr) - 1

        while first < last:
                pos = first + ((last - first) // (arr[last] - arr[first])) * (x - arr[first])

                if arr[pos] == x:
                        return True
                else:
                        if arr[pos] < x:
                                first = pos + 1
                        else:
                                last = pos - 1
        return False

if __name__ == '__main__':
        arr = [int(x) for x in input("Enter the number to be searched from: ").split()]
        x = int(input("Enter the number to be searched for: "))

        print(interpolation_search(arr, x))