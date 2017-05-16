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

def joshephus_solution(data, key):
    q = Queue()
    for name in data:
        q.enqueue(name)


    while q.size() > 1:
        for i in range(key):
            q.enqueue(q.dequeue())
        q.dequeue()

    return q.dequeue()

if __name__ == '__main__':
    data = [x for x in input('Enter the names').split()]
    key = int(input('Enter the key : '))
    name = joshephus_solution(data, key)
    print ("The last man standing is: ", name)
