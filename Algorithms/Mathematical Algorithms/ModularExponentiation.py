__author__ = 'Kalpak Seal'

def modular_exponentiation(x, y, p):
    res = 1
    x = x % p

    while y > 0:
        if y & 1:
            res = (res * x) % p

        y = y >> 1
        x = (x * x) % p

    return res

if __name__ == '__main__':
    print(modular_exponentiation(5, 117, 19))
    print(modular_exponentiation(7, 256, 13))
