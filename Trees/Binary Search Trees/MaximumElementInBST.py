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

def maximum_element_in_BST(root):
    if root is None:
        return -1
    node = root
    while node.get_right() is not None:
        node = node.get_right()

    return node.get_data()

if __name__ == '__main__':
    root = BinarySearchTreeNode(7)

    root.left = BinarySearchTreeNode(5)
    root.right = BinarySearchTreeNode(9)

    root.left.left = BinarySearchTreeNode(2)
    root.left.right = BinarySearchTreeNode(6)

    root.right.left = BinarySearchTreeNode(8)
    root.right.right = BinarySearchTreeNode(10)

    print ("The maximum element in the BST is :", maximum_element_in_BST(root))