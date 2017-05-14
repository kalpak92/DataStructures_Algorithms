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

def minimum_element_in_BST(root):
    if root is None:
        return -1
    if root.get_left() == None:
        return root.get_data()
    else:
        return minimum_element_in_BST(root.get_left())

if __name__ == '__main__':
    root = BinarySearchTreeNode(7)

    root.left = BinarySearchTreeNode(5)
    root.right = BinarySearchTreeNode(9)

    root.left.left = BinarySearchTreeNode(2)
    root.left.right = BinarySearchTreeNode(6)

    root.right.left = BinarySearchTreeNode(8)
    root.right.right = BinarySearchTreeNode(10)
    
    print ("The minimum element in the BST : ", minimum_element_in_BST(root))