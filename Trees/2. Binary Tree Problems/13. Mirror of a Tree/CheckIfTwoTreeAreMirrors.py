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

def are_mirrors(root1, root2):
    if root1 == None and root2 == None:
        return 1
    if root1 == None or root2 == None:
        return 0
    if root1.get_data() != root2.get_data():
        return 0
    else:
        return are_mirrors(root1.get_left(), root2.get_right()) and are_mirrors(root1.get_right(), root2.get_left())

if __name__ == '__main__':
    root1 = BinaryTreeNode(1)

    root1.left = BinaryTreeNode(2)
    root1.right = BinaryTreeNode(3)

    root1.left.left = BinaryTreeNode(4)
    root1.left.right = BinaryTreeNode(5)

    root1.right.left = BinaryTreeNode(6)
    root1.right.right = BinaryTreeNode(7)

    root2 = BinaryTreeNode(1)

    root2.left = BinaryTreeNode(3)
    root2.right = BinaryTreeNode(2)

    root2.left.left = BinaryTreeNode(7)
    root2.left.right = BinaryTreeNode(6)

    root2.right.left = BinaryTreeNode(5)
    root2.right.right = BinaryTreeNode(4)

    print (are_mirrors(root1, root2))
