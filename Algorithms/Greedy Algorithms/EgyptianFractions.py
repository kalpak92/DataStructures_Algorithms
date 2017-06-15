__author__ = 'Kalpak Seal'
'''
Question:
Every positive fraction can be represented as sum of unique unit fractions. 
A fraction is unit fraction if numerator is 1 and denominator is a positive integer, 
for example 1/3 is a unit fraction. Such a representation is called Egyptial Fraction as it was used by ancient Egyptians.

Following are few examples:

Egyptian Fraction Representation of 2/3 is 1/2 + 1/6
Egyptian Fraction Representation of 6/14 is 1/3 + 1/11 + 1/231
Egyptian Fraction Representation of 12/13 is 1/2 + 1/3 + 1/12 + 1/156
'''

def show_egyptian_representation(num, den):
    if num == 0 or den == 0:
        return
    
    if den%num == 0:
        print("1/",den//num,end='')
        return
    
    if num%den == 0:
        print(num//den)
        return
    
    if num > den:
        print(num//den, " +",end='')
        show_egyptian_representation(num%den, den)
        return
    
    n = den // num + 1
    print("1/",n," + ",end ='')
    
    show_egyptian_representation(num*n-den,den*n)
    
def main():
    num = int(input('Enter the numerator'))
    den = int(input('Enter the denominator'))
    
    show_egyptian_representation(num,den)

if __name__ == '__main__':
    main()
