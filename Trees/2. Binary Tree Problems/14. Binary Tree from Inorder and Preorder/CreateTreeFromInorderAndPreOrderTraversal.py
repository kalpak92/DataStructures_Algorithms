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

def construct_binary_tree(pre_order, in_order):
    if not in_order:
        return None

    root = BinaryTreeNode(pre_order[0])
    root_position = in_order.index(pre_order[0])

    root.left = construct_binary_tree(pre_order[1 : root_position + 1], in_order[ : root_position])
    root.right = construct_binary_tree(pre_order[root_position + 1 : ], in_order[root_position + 1 :])

    return root

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


if __name__ == '__main__':
    pre_order = ['A','B','D','E','C','F']
    in_order = ['D','B','E','A','F','C']

    root = construct_binary_tree(pre_order, in_order)
    result = []
    level_order_traversal(root, result)
    print ("The constructed tree is : ", result)