__author__ = "Kalpak Seal"

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

def detect_and_delete_loop(head):
    slow_ptr = head
    fast_ptr = head.next

    while fast_ptr is not None:
        if fast_ptr.next is None:
            break
        if slow_ptr == fast_ptr:
            break
        slow_ptr = slow_ptr.next
        fast_ptr = fast_ptr.next.next

    if slow_ptr == fast_ptr:
        slow_ptr = head
        while slow_ptr != fast_ptr.next:
            slow_ptr = slow_ptr.next
            fast_ptr = fast_ptr.next

        fast_ptr.next = None

    return head

    print (slow_ptr.get_data(), fast_ptr.get_data())
    if slow_ptr == fast_ptr:
        slow_ptr = head
        print (slow_ptr.get_data())
        while slow_ptr != fast_ptr:
            slow_ptr = slow_ptr.next
            fast_ptr = fast_ptr.next
        print(fast_ptr.get_data())
        fast_ptr.next = None

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
    fourth = Node(4)

    llist.head.next = second
    second.next = third
    third.next = fourth
    fourth.next = llist.head.next

    print("Detecting and Deleting loop in the linked list: ")
    llist.head = detect_and_delete_loop(llist.head)
    print_linked_list(llist.head)