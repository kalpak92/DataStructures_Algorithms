__author__ = 'Kalpak Seal'

def fibonacci(n):
    if n < 0:
        print("Incorrect Input")
    elif n == 1:
        return 0
    elif n == 2:
        return 1
    else:
        return fibonacci(n - 1) + fibonacci(n - 2)

if __name__ == '__main__':
    print(fibonacci(10))