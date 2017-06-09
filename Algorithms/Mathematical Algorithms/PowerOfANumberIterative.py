__author__ = 'Kalpak Seal'

def calculate_pow(x, y):
    res = 1.0
    exp = y
    base = x

    if y < 0:
        base = 1 / x
        exp *= -1

    while exp > 0:
        if exp & 1:
            res *= base

        exp = exp >> 1
        base *= base

    return res

if __name__ == '__main__':
    print(calculate_pow(4, 3))
    print(calculate_pow(4, -3))
