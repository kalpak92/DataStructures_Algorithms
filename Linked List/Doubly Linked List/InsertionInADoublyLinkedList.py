__author__ = 'Kalpak Seal'
class Node:
    def __init__(self, data):
        self.data = data
        self.prev = None
        self.next = None

    def get_data(self):
        return self.data


class DoublyLinkedList:
    def __init__(self):
        self.head = None

    def insert_at_beginning(self, data):
        new_node = Node(data)

        new_node.next = self.head

        if self.head is not None:
            self.head.prev = new_node

        self.head = new_node

    def insert_after_given_node(self, prev_node, data):
        if prev_node is None:
            print("The previous node given, cannot be NULL")
            return

        new_node = Node(data)

        new_node.next = prev_node.next
        prev_node.next = new_node
        new_node.prev = prev_node
        if new_node.next is not None:
            new_node.next.prev = new_node

    def insert_at_end(self, data):
        new_node = Node(data)

        if self.head is None:
            self.head = new_node
            return

        current_node = self.head

        while current_node.next is not None:
            current_node = current_node.next

        current_node.next = new_node
        new_node.prev = current_node

        return

    def print_DLL(self, head):
        while head is not None:
            print(head.get_data(), end=' ')
            head = head.next
        print ()


def main():
    d = DoublyLinkedList()
    d.head = Node(1)
    d.insert_at_end(2)
    d.insert_at_end(3)
    d.insert_at_beginning(4)
    d.insert_after_given_node(d.head.next,5)
    d.print_DLL(d.head)

if __name__=='__main__':
    main()
