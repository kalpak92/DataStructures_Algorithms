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

import queue

def insert_in_binary_tree(root, data):
    new_node = BinaryTreeNode(data)
    if root is None:
        root = new_node
        return root

    q = queue.Queue()
    q.put(root)
    node = None
    while not q.empty():
        node = q.get()
        if data == node.get_data():
            return root
        if node.get_left() is not None:
            q.put(node.get_left())
        else:
            node.left = new_node
            return root

        if node.get_right() is not None:
            q.put(node.get_right())
        else:
            node.right = new_node
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
    level_order_traversal(insert_in_binary_tree(root, 8),result)
    print (result)