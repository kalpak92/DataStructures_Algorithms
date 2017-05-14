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

def sum_of_all_elements_recursive(root):
    if root is None:
        return 0
    return  root.get_data() + sum_of_all_elements_recursive(root.get_left()) + sum_of_all_elements_recursive(root.get_right())

import queue

def sum_of_all_elements_iterative(root):
    if root is None:
        return None

    q = queue.Queue()
    q.put(root)
    node = None
    sum = 0
    while not q.empty():
        node = q.get()
        sum += node.get_data()

        if node.get_left() is not None:
            q.put(node.get_left())
        if node.get_right() is not None:
            q.put(node.get_right())

    return sum


if __name__ == '__main__':
    root = BinaryTreeNode(1)

    root.left = BinaryTreeNode(2)
    root.right = BinaryTreeNode(3)

    root.left.left = BinaryTreeNode(4)
    root.left.right = BinaryTreeNode(5)

    root.right.left = BinaryTreeNode(6)
    root.right.right = BinaryTreeNode(7)

    print ("The sum of the value of all nodes is : ", sum_of_all_elements_recursive(root))
    print ("The sum of the value of all nodes is : ", sum_of_all_elements_iterative(root))
