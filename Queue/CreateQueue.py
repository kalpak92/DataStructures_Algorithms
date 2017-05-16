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

if __name__ == '__main__':
    q = Queue()
    q.enqueue(10)
    q.enqueue(20)
    q.enqueue(30)

    print("After enqueueing 3 elements: ")
    q.print()

    print("Dequeueing an element: ", q.dequeue())

    print("Presently the queue is: ")
    q.print()