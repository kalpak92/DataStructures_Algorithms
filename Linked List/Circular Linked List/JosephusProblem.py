__author__ = 'Kalpak Seal'
import gc

class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

    def get_data(self):
        return self.data

class CircularLinkedList:
    def __init__(self):
        self.head = None

    def insert_at_beginning(self, data):
        new_node = Node(data)
        temp = self.head

        new_node.next = self.head

        #If the linked list is not None, then set the next of last node to head

        if self.head is not None:
            while temp.next != self.head:
                temp = temp.next

            temp.next = new_node
        else:
            new_node.next = new_node

        self.head = new_node

    def print_CLL(self):
        temp = self.head

        if self.head is not None:
            while True:
                print(temp.data, end=' ')
                temp = temp.next

                if temp == self.head:
                    break

        print()

def josephus_survivor(head, key):
    p = q = head
    while p.next is not p:
        for i in range(0, key - 1):
            q = p
            p = p.next

        q.next = p.next
        p = q.next
    head = p
    return p.get_data()

if __name__ == '__main__':
    clllist = CircularLinkedList()
    clllist.insert_at_beginning(7)
    clllist.insert_at_beginning(6)
    clllist.insert_at_beginning(5)
    clllist.insert_at_beginning(4)
    clllist.insert_at_beginning(3)
    clllist.insert_at_beginning(2)
    clllist.insert_at_beginning(1)

    clllist.print_CLL()

    key = int(input('Enter the key : '))
    print('The remaining person is: ', josephus_survivor(clllist.head, key))
