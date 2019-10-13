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

def reverse_stack(s):
        return reverse_stack_helper(s, Stack())

def reverse_stack_helper(s, t):
        if s.isEmpty():
                return t
        t.push(s.pop())
        return reverse_stack_helper(s, t)

if __name__ == '__main__':
        s = Stack()
        s.push('x')
        s.push('y')
        s.push('z')
        s.push('a')
        print ("The original stack is:")
        s.print()

        reversed_stack = reverse_stack(s)
        print("The reversed stack is: ")
        reversed_stack.print()
