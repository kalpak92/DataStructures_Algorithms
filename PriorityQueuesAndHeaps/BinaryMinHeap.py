__author__='Kalpak Seal'

class MinHeap:
    def __init__(self):
        self.heap_list = []
        self.size = 0

    def parent(self, index):
        return index // 2

    def left_child_index(self, index):
        return (2 * index + 1)

    def right_child_index(self, index):
        return  (2 * index + 2)

    def left_child(self, index):
        if 2 * index + 1 <= self.size:
            return self.heap_list[2*index + 1]
        return  -1

    def get_minimum(self):
        if self.size == 0:
            return -1
        return self.heap_list[0]


    def right_child(self, index):
        if 2 * index + 2 <= self.size:
            return self.heap_list[2*index + 2]
        return -1

    def insert(self, data):
        self.heap_list.append(data)
        self.size += 1
        self.percolate_up(self.size-1)

    def percolate_up(self, i):
        while i > 0:
            if self.heap_list[i] < self.heap_list[i//2]:
                self.heap_list[i], self.heap_list[i//2] = self.heap_list[i//2], self.heap_list[i]

            i = i//2

    def delete(self):
        n = self.size - 1
        #print (n)
        self.heap_list[0], self.heap_list[n] = self.heap_list[n], self.heap_list[0]
        #self.print_heap()
        min = self.heap_list.pop()
        #print (min)
        self.size -= 1
        #self.print_heap()
        self.percolate_down(0)

        return min

    def percolate_down(self, i):
        while 2*i + 2 < self.size:
            left_child = self.heap_list[2*i + 1]
            right_child = self.heap_list[2*i + 2]

            min_child = min(left_child, right_child)
            min_child_index = self.heap_list.index(min_child)

            if self.heap_list[i] > min_child:
                self.heap_list[i], self.heap_list[min_child_index] = self.heap_list[min_child_index], self.heap_list[i]

            i = min_child_index

    def print_heap(self):
        for i in self.heap_list:
            print(i, end=' ')
        print()


def main():
    h = MinHeap()
    h.insert(9)
    h.insert(8)
    h.insert(7)
    h.insert(5)
    h.insert(3)
    print ("Current MIN heap after insertion: ")
    h.print_heap()

    print ("After deleting 1 element: ")
    h.delete()
    h.print_heap()
    
if __name__ == '__main__':
    main()


