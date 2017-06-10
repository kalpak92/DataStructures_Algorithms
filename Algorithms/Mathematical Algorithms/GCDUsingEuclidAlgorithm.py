__author__ = 'Kalpak Seal'
'''
The Algorithm
The Euclidean Algorithm for finding GCD(A,B) is as follows:
•	If A = 0 then GCD(A,B)=B, since the GCD(0,B)=B, and we can stop.  
•	If B = 0 then GCD(A,B)=A, since the GCD(A,0)=A, and we can stop.  
•	Write A in quotient remainder form (A = B⋅Q + R)
•	Find GCD(B,R) using the Euclidean Algorithm since GCD(A,B) = GCD(B,R)

'''
def calculate_gcd(a, b):
    if (a == 0):
        return b
    return calculate_gcd(b%a, a)

if __name__ == '__main__':
    print(calculate_gcd(0, 5))
    print(calculate_gcd(6, 0))
    print(calculate_gcd(270, 192))
