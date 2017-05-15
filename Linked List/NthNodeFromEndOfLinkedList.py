__author__= 'Kalpak Seal'

'''
Process:
Maintain two pointers – reference pointer and main pointer. Initialize both reference and main pointers to head. 
First move reference pointer to n nodes from head. Now move both pointers one by one until reference pointer reaches end. 
Now main pointer will point to nth node from the end. 
Return main pointer.
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

def nth_node_from_end_of_linked_list(head, n):
    main_ptr = head
    ref_ptr = head

    count = 0

    if head is not None:
        while count < n:
            if ref_ptr is None:
                print(n, " is greater than the number of nodes in the linked list")
                return
            ref_ptr = ref_ptr.next
            count += 1

    while ref_ptr is not None:
        ref_ptr = ref_ptr.next
        main_ptr = main_ptr.next

    print ("The %dth node from the end of the linked list is : %d" %(n, main_ptr.get_data()))


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

    nth_node_from_end_of_linked_list(llist.head, 3)