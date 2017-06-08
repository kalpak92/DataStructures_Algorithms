__author__ = 'Kalpak Seal'

def calculate_pow(x, y):
    if y == 0:
        return 1
    elif y == 1:
        return  x
    elif y == -1:
        return 1/float(x)

    temp = calculate_pow(x, y//2)

    if y%2 == 0:
        return temp * temp
    
    else:
        if y > 0:
            return x * temp * temp

        elif y == -3:
            return temp/x

        else:
            return (temp*temp)/x

if __name__ == '__main__':
    print("The result of 14 raised to 12 is : ", calculate_pow(14, 12))
    print("The result of 4 raised to -3 is : ", calculate_pow(4, -3))
