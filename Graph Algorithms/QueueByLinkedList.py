# -*- coding: utf-8 -*-

class Node:
    # constructor
    def __init__(self, data=None, next=None):
        self.data = data
        self.next = next

    # method for setting the data field of the node
    def set_data(self, data):
        self.data = data

    # method for getting the data field of the node
    def get_data(self):
        return self.data

    # method for setting the next field of the node
    def set_next(self, next):
        self.next = next

    # method for getting the last field of the node
    def getNext(self):
        return self.next

    # returns true if the node points to another node
    def has_next(self):
        return self.next != None


class Queue(object):
    def __init__(self, data=None):
        self.front = None
        self.rear = None
        self.size = 0

    def enQueue(self, data):
        if (self.rear == None):  # q.empty()
            self.front = Node(data)
            self.rear = self.front
        else:
            lastNode = self.rear
            self.rear = Node(data)
            lastNode.next = self.rear
        self.size += 1

    def queueRear(self):
        if self.rear is None:
            print("Sorry, the queue is empty!")
            raise IndexError
        return self.rear.get_data()

    def queueFront(self):
        if self.front is None:
            print("Sorry, the queue is empty!")
            raise IndexError
        return self.front.get_data()

    def deQueue(self):
        if self.rear is None:
            print("Sorry, the queue is empty!")
            raise IndexError
        result = self.front.get_data()
        self.front = self.front.next
        self.size -= 1
        return result

    def size(self):
        return self.size


que = Queue()
que.enQueue("first")

print("Front: " + que.queueFront())
print("Rear: " + que.queueRear())
'''
que.enQueue("second")
print ("Front: " + que.queueFront())
print ("Rear: " + que.queueRear())
que.enQueue("third")
print ("Front: " + que.queueFront())
print ("Rear: " + que.queueRear())
'''
print("Dequeuing: " + que.deQueue())
# print ("Front: " + que.queueFront())
# print ("Rear: " + que.queueRear())
