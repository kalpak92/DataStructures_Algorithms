__author__='Kalpak Seal'
'''
A small hash function
'''

def hash(astring, tablesize):
        sum = 0
        for pos in range(len(astring)):
                sum = sum + ord(astring[pos])

        return sum%tablesize

def main():
        arr = [x for x in input('Enter names to compute Hash ').split()]
        tablesize = int(input('Enter the table size '))

        for i in range(len(arr)):
                #print (arr[i])
                print (hash(arr[i], tablesize))

if __name__ == '__main__':
        main()
