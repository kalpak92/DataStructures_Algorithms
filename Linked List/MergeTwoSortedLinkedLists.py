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

def print_linked_list(head):
    temp = head
    while temp:
        print(temp.get_data(), end=' ')
        temp = temp.next
    print()

def merge_sorted_linked_lists(head1, head2):
    temp = None
    if head1 is None:
        return head2
    if head2 is None:
        return head1

    if head1.get_data() < head2.get_data():
        temp = head1
        temp.next = merge_sorted_linked_lists(head1.next, head2)
    else:
        temp = head2
        temp.next = merge_sorted_linked_lists(head1, head2.next)

    return temp



if __name__ == '__main__':
    llist1 = LinkedList()
    llist1.insert_at_beginning(301)
    llist1.insert_at_beginning(99)
    llist1.insert_at_beginning(75)
    llist1.insert_at_beginning(55)
    llist1.insert_at_beginning(16)
    llist1.insert_at_beginning(2)

    print("The first linked list is :")
    print_linked_list(llist1.head)

    llist2 = LinkedList()
    llist2.insert_at_beginning(299)
    llist2.insert_at_beginning(103)
    llist2.insert_at_beginning(89)
    llist2.insert_at_beginning(57)
    llist2.insert_at_beginning(19)
    llist2.insert_at_beginning(10)

    print("The second linked list is : ")
    print_linked_list(llist2.head)

    llist3 = LinkedList()
    llist3.head = merge_sorted_linked_lists(llist1.head, llist2.head)

    print ("The sorted merged linked list is: ")
    print_linked_list(llist3.head)