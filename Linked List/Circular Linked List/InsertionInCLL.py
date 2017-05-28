__author__ = 'Kalpak Seal'

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

if __name__ == '__main__':
    clllist = CircularLinkedList()
    clllist.insert_at_beginning(12)
    clllist.insert_at_beginning(56)
    clllist.insert_at_beginning(2)
    clllist.insert_at_beginning(20)

    clllist.print_CLL()
