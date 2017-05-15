__author__ = 'Kalpak Seal'

'''
Input : Head of following linked list  
       1->2->3->4->NULL
Output : Linked list should be changed to,
       4->3->2->1->NULL

Input : Head of following linked list  
       1->2->3->4->5->NULL
Output : Linked list should be changed to,
       5->4->3->2->1->NULL

Input : NULL
Output : NULL

Input  : 1->NULL
Output : 1->NULL
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

def reverse_a_linked_list(head):
    prev = None
    current = head

    while current is not None:
        next = current.next
        current.next = prev
        prev = current
        current = next

    head = prev
    return head


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

    llist.insert_at_beginning(4)
    llist.insert_at_end(5)
    llist.insert_after_a_node(llist.head.next, 6)

    print("The linked list is: ")
    print_linked_list(llist.head)

    llist.head = reverse_a_linked_list(llist.head)

    print ("The reversed linked list is : ")
    print_linked_list(llist.head)
