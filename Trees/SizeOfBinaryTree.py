__author__='Kalpak Seal'

'''
Size of a Binary Tree is the number of descendants it has including itself.
'''

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

def size_of_binary_tree_recursive(root):
    if root is None:
        return 0
    return size_of_binary_tree_recursive(root.get_left()) + size_of_binary_tree_recursive(root.get_right()) + 1

import queue
def size_of_binary_tree_iterative(root):
    if root is None:
        return 0

    q = queue.Queue()
    q.put(root)
    node = None
    count = 0

    while not q.empty():
        node = q.get()
        count += 1

        if node.get_left() is not None:
            q.put(node.get_left())

        if node.get_right() is not None:
            q.put(node.get_right())

    return count

if __name__ == '__main__':
    root = BinaryTreeNode(1)

    root.left = BinaryTreeNode(2)
    root.right = BinaryTreeNode(3)

    root.left.left = BinaryTreeNode(4)
    root.left.right = BinaryTreeNode(5)

    root.right.left = BinaryTreeNode(6)
    root.right.right = BinaryTreeNode(7)

    print (size_of_binary_tree_recursive(root))
    print (size_of_binary_tree_iterative(root))