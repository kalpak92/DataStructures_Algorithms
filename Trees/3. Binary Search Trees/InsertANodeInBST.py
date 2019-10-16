__author__='Kalpak Seal'

class BinarySearchTreeNode:
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

def insert_node_in_BST(root, node):
    if root is None:
        root = node
    else:
        if root.get_data() > node.get_data():
            if root.get_left() is None:
                root.left = node
            else:
                insert_node_in_BST(root.get_left(), node)
        else:
            if root.get_right() is None:
                root.right = node
            else:
                insert_node_in_BST(root.get_right(), node)


if __name__ == '__main__':

    root = BinarySearchTreeNode(7)

    root.left = BinarySearchTreeNode(5)
    root.right = BinarySearchTreeNode(9)

    root.left.left = BinarySearchTreeNode(2)
    root.left.right = BinarySearchTreeNode(6)

    root.right.left = BinarySearchTreeNode(8)
    root.right.right = BinarySearchTreeNode(10)

    result = []
    level_order_traversal(root, result)
    print (result)

    node = BinarySearchTreeNode(12)
    insert_node_in_BST(root, node)

    result_after_insertion = []
    level_order_traversal(root, result_after_insertion)
    print (result_after_insertion)
