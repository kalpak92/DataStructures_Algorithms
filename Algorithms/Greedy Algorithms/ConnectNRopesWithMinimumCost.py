__author__ = 'Kalpak Seal'
 
'''
Question:
There are given n ropes of different lengths, we need to connect these ropes into one rope.
The cost to connect two ropes is equal to sum of their lengths.
We need to connect the ropes with minimum cost.
 
Algorithm:
 
1) Store array’s element in Min heap.
    do
        2) Get first minimum and second minimum
        3) Add them and store result in min heap and update “SUM”.
    while(heap’s length > 1)
 
'''
 
import heapq
 
def find_minimum_cost(rope_cost):
    heapq.heapify(rope_cost)
    #print(rope_cost)
 
    res = 0
 
    while len(rope_cost) > 1:
        first = heapq.heappop(rope_cost)
        #print(first)
        second = heapq.heappop(rope_cost)
        #print(second)
        res += first + second
        heapq.heappush(rope_cost, (first + second))
 
    return res
 
 
def main():
    rope_cost = [4, 3, 2, 6]
    print("Minimum cost for connecting the ropes : ", find_minimum_cost(rope_cost))
 
if __name__ == '__main__':
    main()
