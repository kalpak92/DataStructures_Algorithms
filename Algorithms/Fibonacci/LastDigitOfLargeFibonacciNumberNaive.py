__author__ = 'Kalpak Seal'
'''
Question:
Find the last digit of n-th Fibonacci number. 
Recall that Fibonacci numbers grow exponentially fast. 

For example,
F200 = 280571172992510140037611932413038677189525.

Algorithm:

Because it grows exponentially fast, we can not use fast_fibonacci(n) % 10 to give the answer. 
We need another approach to this case. 
Instead of summing Fn-1 + Fn-2, we just sum the last digit of Fn-1 and last digit of Fn-2.
'''

def get_fibonacci_last_digit_naive(n):

        if n <= 1:
                return n

        previous = 0
        current  = 1

        for _ in range(n - 1):
                previous, current = current, (previous + current) % 10

        return current

if __name__ == '__main__':
        print(get_fibonacci_last_digit_naive(200))
