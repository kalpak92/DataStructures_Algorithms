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
            print(i)

class QueueUsingStack:
    def __init__(self):
        self.stack1 = Stack()
        self.stack2 = Stack()

    def enqueue(self, data):
        self.stack1.push(data)

    def dequeue(self):
        if self.stack1.isEmpty() and self.stack2.isEmpty():
            return None

        if self.stack2.isEmpty():
            while not self.stack1.isEmpty():
                self.stack2.push(self.stack1.pop())

        return self.stack2.pop()

if __name__ == '__main__':
    q = QueueUsingStack()
    q.enqueue(10)
    q.enqueue(20)
    q.enqueue(30)
    q.enqueue(40)

    print("The popped element is : ", q.dequeue())
    print("The popped element is : ", q.dequeue())
    print("The popped element is : ", q.dequeue())