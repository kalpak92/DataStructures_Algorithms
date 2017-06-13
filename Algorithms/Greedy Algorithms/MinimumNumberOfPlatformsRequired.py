__author__ = 'Kalpak Seal'

'''
Given arrival and departure times of all trains that reach a railway station, 
find the minimum number of platforms required for the railway station so that no train waits.

We are given two arrays which represent arrival and departure times of trains that stop
'''

def count_number_of_platforms(arrival, departure):
    arrival.sort()
    departure.sort()

    temp = 1
    platform_needed = 1
    i = 1
    j = 0

    while (i < len(arrival) and j < len(arrival)):
        if arrival[i] < departure[j]:
            temp += 1
            i += 1

            if temp > platform_needed:
                platform_needed = temp
        else:
            temp -= 1
            j += 1

    return platform_needed

if __name__ == '__main__':
    arrival = [900, 940, 950, 1100, 1500, 1800]
    departure = [910, 1200, 1120, 1130, 1900, 2000]

    print("The number of platforms required are: ", count_number_of_platforms(arrival, departure))
