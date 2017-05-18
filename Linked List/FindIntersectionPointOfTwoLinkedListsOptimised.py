__author__ = 'Kalpak Seal'

#########################################################################################
# Technique: We start from the heads of each list. We traverse both together            #
# until we converge at the common node. If we reach the end of any list before that,    #
# we make the current pointer of that list to point to the head of the other list.      #
# NB: This will work either on the 1st iteration of both lists if length of both lists  #
# are same, or on the second iteration. But the thing is we will always meet at the     #
# point of merge. For two lists, say upto the point of merge the length of one list is #
# X, while for the other it is (X + Δ). Also, let the length from the merge node to the #
# end be Z. Then when we move over to the other lists, the basic traversal will become  #
# equal. So, for list1 it will be X + Z + (X + Δ) = 2X + Z + Δ. For list2, it will be   #
# (X + Δ) + Z + X = 2X + Z + Δ. As can be understood, if Δ is 0, then we do not need    #
# the second iteration. But ultimately, we will always meet at the merge node.          #
#########################################################################################


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

def find_merge_node(headA, headB):
    currentA = headA
    currentB = headB
    while (currentA.get_data() != currentB.get_data()):
        # for list A
        if currentA.next is None:
            currentA = headB
        else:
            currentA = currentA.next
        # for list B
        if currentB.next is None:
            currentB = headA
        else:
            currentB = currentB.next
    return currentB.get_data()

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

    print ("The Intersection point of the two linked lists is : ", find_merge_node(llist1.head, llist2.head))

if __name__ == '__main__':
    main()
