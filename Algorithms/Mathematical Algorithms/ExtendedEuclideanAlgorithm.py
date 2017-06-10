__author__ = 'Kalpak Seal'

def extended_euclid(a, b):
    x0, x1, y0, y1 = 1, 0, 0, 1

    while b != 0:
        q, a, b = a//b, b, b%a
        x0, x1 = x1, x0 - q * x1
        y0, y1 = y1, y0 - q * y1

    return a, x0, y0

if __name__ == '__main__':
    print(extended_euclid(30, 20))
    print(extended_euclid(35, 15))
