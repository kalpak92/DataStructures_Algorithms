__author__ = 'Kalpak Seal'

'''
LOGIC:

x^N can be rewritten as the product of power where they sum to N, i.e.

x**100 == x**90 * x**10
So the aim is to get large numbers in the indices without doing lots of calculations:

x**2 is just as difficult as x*x - they take the same amount of time. 
But x*x*x*x gives the same answer as (x**2)**2 while requiring an extra multiplication. 
The gains get more as you go to higher powers. So if you break down the exponent into powers of 2 (any power works, 
but this is the simplest case),

X**100 == X**64 * X**32 * X**4
i.e.

X**100 == (((((X**2)**2)**2)**2)**2)**2 + ...
So what you do, is work out the powers of two of the total power you want to reach, 
and then take the product of those powers of two of the Q matrix.
'''


def matrix_square(A, mod):
    return mat_mult(A,A,mod)


def mat_mult(A,B, mod):
  if mod is not None:
    return [[(A[0][0]*B[0][0] + A[0][1]*B[1][0])%mod, (A[0][0]*B[0][1] + A[0][1]*B[1][1])%mod],
            [(A[1][0]*B[0][0] + A[1][1]*B[1][0])%mod, (A[1][0]*B[0][1] + A[1][1]*B[1][1])%mod]]


def get_nth_fibonacci(M, power, mod):
    #Special definition for power=0:
    if power <= 0:
      return M
    #print (bin(power))
    powers =  list(reversed([True if i=="1" else False for i in bin(power)[2:]])) #Order is 1,2,4,8,16,...
    #print(powers)

    matrices = [None for _ in powers]
    #print(matrices)
    matrices[0] = M

    for i in range(1,len(powers)):
        matrices[i] = matrix_square(matrices[i-1], mod)

    #print (matrices)
    result = None

    for matrix, power in zip(matrices, powers):
        if power:
            if result is None:
                result = matrix
            else:
                result = mat_mult(result, matrix, mod)

    return result

if __name__ == '__main__':
    fib_matrix = [[1, 1],
                  [1, 0]]

    x = int(input("Enter the fibonacci number of choice"))
    print ("The ", str(x),"th fibonacci is ", str(get_nth_fibonacci(fib_matrix, x, 10**9+7)[1][0]))