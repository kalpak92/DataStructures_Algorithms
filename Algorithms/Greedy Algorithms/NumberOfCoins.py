__author__ = 'Kalpak Seal'

'''
Question: 
Given a value V, if we want to make change for V Rs, and we have infinite supply of each of the denominations in Indian currency, 
i.e., we have infinite supply of { 1, 2, 5, 10, 20, 50, 100, 500, 1000} valued coins/notes, 
what is the minimum number of coins and/or notes needed to make the change?

Input: V = 70
Output: 2
We need a 50 Rs note and a 20 Rs note.

Input: V = 121
Output: 3
We need a 100 Rs note, a 20 Rs note and a 
1 Rs coin. 

'''

def get_number_of_notes(denomination, x):
    res = 0
    
    for i in range(len(denomination) - 1, -1, -1):
        if x >= denomination[i]:
            res += x//denomination[i]
            x %= denomination[i]
    
    return res

def main():
    denomination = [1, 2, 5, 10, 20, 50, 100, 500, 1000]
    x = int(input('Enter a Value: '))
    
    print("The number of notes required to represent the value is : ",get_number_of_notes(denomination, x))

if __name__ == '__main__':
    main()
