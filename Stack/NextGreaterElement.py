__author__ = 'Kalpak Seal'

class Stack:
        def __init__(self):
                self.stack = []

        def isEmpty(self):
                return self.stack == []

        def push(self, data):
                self.stack.insert(0, data)

        def pop(self):
                return self.stack.pop(0)

        def peek(self):
                return self.stack[0]

        def size(self):
                return len(self.stack)

        def print(self):
                for i in self.stack:
                        print (i)

def find_next_greater_element(s, arr):
        element, next = 0, 0
        s.push(arr[0])

        for i in range(1, len(arr)):
                next = arr[i]

                if s.size() != 0:
                        element = s.pop()

                        while element < next:
                                print ("NGE of ",str(element)," is ",str(next))
                                if s.size() == 0:
                                        break
                                element = s.pop()

                        if element > next :
                                s.push(element)
                s.push(next)


        while s.isEmpty() == False:
                element = s.pop()
                next = -1
                print ("NGE of ",str(element)," is ",str(next))


if __name__ == '__main__':
        s = Stack()

        arr = [int(x) for x in input('Enter the elements : ').split()]

        find_next_greater_element(s, arr)
