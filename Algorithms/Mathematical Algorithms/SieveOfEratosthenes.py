__author__ = 'Kalpak Seal'

def prime_sieve(n):
    prime = [True for i in range(n + 1)]

    p = 2
    while p*p <= n:
        if prime[p] == True:
            for i in range(p*2, n + 1, p):
                prime[i] = False

        p += 1

    for p in range(2, n):
        if prime[p]:
            print(p, end=' ')
    print('\n')

if __name__ == '__main__':
    n = 50
    prime_sieve(n)
