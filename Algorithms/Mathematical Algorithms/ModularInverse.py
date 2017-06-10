__author__ = 'Kalpak Seal'

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
