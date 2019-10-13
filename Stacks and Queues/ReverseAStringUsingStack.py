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

def reverse_a_string(s, data):
        for i in range(0, len(data)):
                s.push(data[i])

        reverse_data = ""
        for i in range(0, len(data)):
                reverse_data += s.pop()

        return reverse_data

if __name__ == '__main__':
        s = Stack()
        data = input("Enter a string ")

        reverse_data = reverse_a_string(s, data)
        print ("The reversed string is : ", reverse_data)
