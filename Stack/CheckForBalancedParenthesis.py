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

def is_valid_pair(left, right):
        if left == '(' and right == ')':
                return True
        if left == '[' and right == ']':
                return True
        if left == '{' and right == '}':
                return True
        return False

def is_balanced_parenthesis(s, l):
        for symbol in l:
                if symbol == '[' or symbol == '{' or symbol == '(':
                        s.push(symbol)
                else:
                        if s.size() == 0:
                                return False
                        last = s.pop()
                        if not is_valid_pair(last, symbol):
                                return False
        if s.size() != 0:
                return False

        return True


if __name__ == '__main__':
        s = Stack()
        l = [x for x in input('Enter the list of parenthesis').split()]

        print(is_balanced_parenthesis(s, l))