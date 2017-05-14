__author__='Kalpak Seal'

class BinaryTreeNode:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

    def set_data(self, data):
        self.data = data

    def get_data(self):
        return self.data

    def get_left(self):
        return self.left

    def get_right(self):
        return self.right

def search_element_in_tree(root, data):
    if not root:
        return -1

    if root.get_data() == data:
        return 1
    else:
        temp =  search_element_in_tree(root.get_left(), data)
        if temp == 1:
            return temp
        else:
            return search_element_in_tree(root.get_right(),data)

import queue

def search_element_in_a_tree_iterative(root, data):
    if root is None:
        return -1

    q = queue.Queue()
    q.put(root)
    node = None

    while not q.empty():
        node = q.get()
        if node.get_data() == data:
            return 1
        else:
            if node.get_left() is not None:
                q.put(node.get_left())
            if node.get_right() is not None:
                q.put(node.get_right())

    return -1

if __name__ == '__main__':
    root = BinaryTreeNode(1)

    root.left = BinaryTreeNode(2)
    root.right = BinaryTreeNode(3)

    root.left.left = BinaryTreeNode(4)
    root.left.right = BinaryTreeNode(5)

    root.right.left = BinaryTreeNode(6)
    root.right.right = BinaryTreeNode(7)

    data = int(input('Enter the element to be searched for:  ?? '))
    print (search_element_in_tree(root, data))

    print(search_element_in_a_tree_iterative(root, data))
