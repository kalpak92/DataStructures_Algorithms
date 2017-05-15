__author__ = 'Kalpak Seal'

'''
To delete a node from linked list, we need to do following steps.
    1) Find previous node of the node to be deleted.
    2) Changed next of previous node.
    3) Free memory for the node to be deleted.
'''


class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

    def get_data(self):
        return self.data


class LinkedList:
    def __init__(self):
        self.head = None

    def insert_at_beginning(self, data):
        new_node = Node(data)
        new_node.next = self.head
        self.head = new_node

    def insert_after_a_node(self, prev_node, data):
        if prev_node is None:
            print("Not a Valid previous node")
            return

        new_node = Node(data)
        new_node.next = prev_node.next
        prev_node.next = new_node

    def insert_at_end(self, data):
        new_node = Node(data)

        if self.head is None:
            self.head = new_node
            return

        last_node = self.head
        while last_node.next is not None:
            last_node = last_node.next

        last_node.next = new_node

    def delete_a_node(self, data):
        #store the head
        temp = self.head
        prev_node = None

        #If head node itself is to be deleted
        if temp is not None:
            if temp.get_data() == data:
                self.head = temp.next
                temp = None
                return

        # Search for the key to be deleted, keep track of the
        # previous node as we need to change 'prev.next'
        while temp is not None:
            if temp.get_data() == data:
                break
            prev_node = temp
            temp = temp.next


        # if key was not present in linked list
        if temp is None:
            return

        # Unlink the node from linked list
        prev_node.next = temp.next
        temp = None

def print_linked_list(head):
    temp = head
    while temp:
        print(temp.get_data(), end=' ')
        temp = temp.next
    print()


if __name__ == '__main__':
    llist = LinkedList()
    llist.head = Node(1)
    second = Node(2)
    third = Node(3)

    llist.head.next = second
    second.next = third

    print_linked_list(llist.head)

    llist.insert_at_beginning(4)
    llist.insert_at_end(5)
    llist.insert_after_a_node(llist.head.next, 6)

    print("The final linked list is: ")
    print_linked_list(llist.head)

    llist.delete_a_node(6)
    print("The linked list after deletion is : ")
    print_linked_list(llist.head)

    llist.delete_a_node(4)
    print("The linked list after deletion is : ")
    print_linked_list(llist.head)