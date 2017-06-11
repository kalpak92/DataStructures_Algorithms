__author__ = 'Kalpak Seal'

def isPrime(n):
    if n <= 1:
        return False
    if n <= 3:
        return True

    if n % 2 == 0 or n % 3 == 0:
        return False

    i = 5
    while i*i <= n:                       # Check whether n is divisible by 6K - 1 or 6K + 1 (the difference between them is 2
        if n % i == 0 or n % (i + 2) == 0:
            return False
        i += 6

    return True

if __name__ == '__main__':
    print(isPrime(97))
    print(isPrime(84))
