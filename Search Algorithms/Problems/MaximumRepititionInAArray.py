__author__='Kalpak Seal'
def max_repitition_with_hash(arr):
    table = {}
    max = 0
    for element in arr:
        if element in table:
            table[element] += 1
        elif element != '':
            table[element] = 1

    for element in arr:
        if table[element] > max:
            max = table[element]
            max_repeated_element = element

    return max_repeated_element

if __name__ == '__main__':
    arr = [int(x) for x in input("Enter the numbers in the array: ").split()]
    print(max_repitition_with_hash(arr))
