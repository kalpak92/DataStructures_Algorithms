__author__ = 'Kalpak Seal'

class Deque:
    def __init__(self):
        self.deque = []

    def isEmpty(self):
        return self.deque == []

    def add_front(self, data):
        self.deque.insert(0, data)

    def add_rear(self, data):
        self.deque.append(data)

    def remove_front(self):
        return self.deque.pop(0)

    def remove_rear(self):
        return self.deque.pop()

    def size(self):
        return len(self.deque)

    def print(self):
        for i in self.deque:
            print (i, end=' ')
        print ()

if __name__ == '__main__':
    d = Deque()

    d.add_rear(4)
    d.add_rear('dog')
    d.add_front('cat')
    d.add_front(True)
    d.add_rear(8.4)

    print("The size of the deque is : ", d.size())
    print ("The deque is :")
    d.print()

    d.remove_rear()
    d.remove_front()
    print("After removing two elements from front and end, the deque is: ")
    d.print()

