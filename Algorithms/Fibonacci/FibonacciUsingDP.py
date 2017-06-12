__author__ = 'Kalpak Seal'


def fibonacci(n):
    a = 0
    b = 1
    if n < 0:
        print("Incorrect Input")
        return
    elif n == 0:
        print(a, end=' ')
    elif n == 1:
        print(b, end=' ')
    else:
        print(a, b, end=' ')
        for i in range(2, n):
            c = a + b
            a = b
            b = c
            print(c, end=' ')
        print('\n')


if __name__ == '__main__':
    fibonacci(9)
    fibonacci(250)