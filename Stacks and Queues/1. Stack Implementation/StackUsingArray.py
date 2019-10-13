__author__='Kalpak Seal'

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

if __name__ == '__main__':
        s = Stack()
        print ("Pushing 2 elements: ")
        s.push('x')
        s.push('y')
        s.print()
        print ("Popping an element")
        s.pop()
        s.print()
        print ("Pushing an element")
        s.push('z')
        s.print()
