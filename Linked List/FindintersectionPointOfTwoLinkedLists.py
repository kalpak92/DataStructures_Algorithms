__author__ = 'Kalpak Seal'

class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

    def get_data(self):
        return self.data


class LinkedList:
    def __init__(self):
        self.head = None



def print_linked_list(head):
    temp = head
    while temp:
        print(temp.get_data(), end = ' ')
        temp = temp.next
    print ()

def get_count(head):
    current_node = head
    count = 0

    while current_node is not None:
        count += 1
        current_node = current_node.next

    return count

def _get_intersection_node_helper(difference, head1, head2):
    current_node1 = head1
    current_node2 = head2

    for i in range(difference):
        if current_node1 is None:
            return -1
        current_node1 = current_node1.next

    while current_node1 is not None and current_node2 is not None:
        if current_node1.get_data() == current_node2.get_data():
            return current_node1.get_data()

        current_node1 = current_node1.next
        current_node2 = current_node2.next

    return -1

def get_intersection_node(head1, head2):
    count1 = get_count(head1)
    count2 = get_count(head2)

    difference = 0

    if count1 > count2:
        difference = count1 - count2
        return _get_intersection_node_helper(difference, head1, head2)
    else:
        difference = count2 - count1
        return _get_intersection_node_helper(difference, head2, head1)

def main():
    llist1 = LinkedList()
    llist1.head = Node(1)
    llist1.head.next = Node(2)
    llist1.head.next.next = Node(3)
    llist1.head.next.next.next = Node(4)
    llist1.head.next.next.next.next = Node(5)
    llist1.head.next.next.next.next.next = Node (6)

    llist2 = LinkedList()
    llist2.head = Node(9)
    llist2.head.next = Node(8)
    llist2.head.next.next = Node(7)
    llist2.head.next.next.next = Node(5)
    llist2.head.next.next.next.next = Node(6)

    print ("The Intersection point of the two linked lists is : ", get_intersection_node(llist1.head, llist2.head))

if __name__ == '__main__':
    main()
