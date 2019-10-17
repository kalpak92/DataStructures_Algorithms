__author__='Kalpak Seal'
'''
Mirror of a tree is another tree with left and right children of all non leaf nodes interchanged.
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

import queue
def level_order_traversal(root, result):
    if root is None:
        return

    q = queue.Queue()
    q.put(root)
    node = None

    while not q.empty():
        node = q.get()
        result.append(node.get_data())

        if node.get_left() is not None:
            q.put(node.get_left())
        if node.get_right() is not None:
            q.put(node.get_right())

def mirror_of_binary_tree(root):
    if root is not None:
        mirror_of_binary_tree(root.get_left())
        mirror_of_binary_tree(root.get_right())

        temp = root.get_left()
        root.left = root.get_right()
        root.right = temp

    return root


if __name__ == '__main__':
    root = BinaryTreeNode(1)

    root.left = BinaryTreeNode(2)
    root.right = BinaryTreeNode(3)

    root.left.left = BinaryTreeNode(4)
    root.left.right = BinaryTreeNode(5)

    root.right.left = BinaryTreeNode(6)
    root.right.right = BinaryTreeNode(7)

    result = []
    level_order_traversal(root, result)
    print ("The tree is: ", result)
    result_mirror = []
    level_order_traversal(mirror_of_binary_tree(root),result_mirror)
    print ("The mirror of the tree is: ", result_mirror)
