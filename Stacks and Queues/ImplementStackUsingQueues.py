__author__ = 'Kalpak Seal'

class Queue:
    def __init__(self):
        self.queue = []

    def isEmpty(self):
        return self.queue == []

    def enqueue(self,data):
        self.queue.append(data)

    def dequeue(self):
        return self.queue.pop(0)

    def size(self):
        return len(self.queue)

    def print(self):
        for i in self.queue:
            print (i, end=' ')
        print()

class StackUsingQueues:
    def __init__(self):
        self.queue1 = Queue()
        self.queue2 = Queue()

    def push(self, data):
        self.queue1.enqueue(data)

    def pop(self):
        while self.queue1.size() > 1:
            self.queue2.enqueue(self.queue1.dequeue())

        result = self.queue1.dequeue()

        self.queue1, self.queue2 = self.queue2, self.queue1
        return result

if __name__ == '__main__':
    s = StackUsingQueues()
    s.push(1)
    s.push(2)
    s.push(3)
    s.push(4)
    s.push(5)

    print ("Popping now")
    print(s.pop())
    print(s.pop())
    print(s.pop())