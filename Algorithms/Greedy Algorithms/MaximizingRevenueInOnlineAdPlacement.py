#Uses python3
'''
Question:
You have n ads to place on a popular Internet page. 
For each ad, you know how much is the advertiser willing to pay for one click on this ad. 
You have set up n slots on your page and estimated the expected number of clicks per day for each slot. 
Now, your goal is to distribute the ads among the slots to maximize the total revenue.

Problem Description:
Given two sequences a1, a2,…, an (ai is the profit per click of the i-th ad) and b1,b2,…,
					bn (bi is the average number of clicks per day of the i-th slot),
we need to partition them into n pairs (ai,bj) such that the sum of their products is maximized.
'''

import sys

def max_dot_product(a, b):
    res = 0
    for i in range(len(a)):
        max_a = get_max_index(a)
        max_b = get_max_index(b)
        res = res + a[max_a] * b[max_b]
        del a[max_a]
        del b[max_b]
    return res

def get_max_index(array):
    max = array[0]
    index = 0
    for i in range(len(array)):
        if max < array[i]:
            max = array[i]
            index = i
    return index

if __name__ == '__main__':
    input = sys.stdin.read()
    data = list(map(int, input.split()))
    n = data[0]
    a = data[1:(n + 1)]
    b = data[(n + 1):]
    print(max_dot_product(a, b))
