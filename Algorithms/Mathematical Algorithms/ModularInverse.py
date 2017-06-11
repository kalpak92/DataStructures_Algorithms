__author__ = 'Kalpak Seal'

'''
ax + by = gcd(a, b)

To find multiplicative inverse of ‘a’ under ‘m’, we put b = m in above formula. 

Since we know that a and m are relatively prime, we can put value of gcd as 1.
 ax + my = 1 
 
If we take modulo m on both sides, we get
 ax + my ≡ 1 (mod m)
 
We can remove the second term on left side as ‘my (mod m)’ would always be 0 for an integer y.
 ax  ≡ 1 (mod m) 
 
So the ‘x’ that we can find using Extended Euclid Algorithm is multiplicative inverse of ‘a’

'''

def extended_euclid(a, b):
    x0, x1, y0, y1 = 1, 0, 0, 1

    while b != 0:
        q, a, b = a//b, b, a%b
        x0, x1 = x1, x0 - q * x1
        y0, y1 = y1, y0 - q * y1

    return a, x0, y0

def modular_inverse(a , m):
    g, x , _ = extended_euclid(a, m)

    if g == 1:
        return x % m

if __name__ == '__main__':
    print(modular_inverse(3, 11))
