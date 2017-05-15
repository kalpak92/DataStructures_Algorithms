__author__='Kalpak Seal'

'''
Algorithm: reverse(head, k)
1) Reverse the first sub-list of size k. While reversing keep track of the next node and previous node. 
    Let the pointer to the next node be next and pointer to the previous node be prev. 
2) head->next = reverse(next, k) /* Recursively call for rest of the list and link the two sub-lists */
3) return prev /* prev becomes the new head of the list

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

def reverse_linked_list_in_groups(head, k):
    current = head
    next = None
    prev = None
    count = 0

    while current is not None and count < k:
        next = current.next
        current.next = prev
        prev = current
        current = next
        count += 1

    if next is not None:
        head.next = reverse_linked_list_in_groups(next, k)

    return prev


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

    print("The linked list is: ")
    print_linked_list(llist.head)

    k = int(input('Enter the value of number of nodes in each group: '))
    llist.head = reverse_linked_list_in_groups(llist.head, k)
    print_linked_list(llist.head)
