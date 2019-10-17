__author__='Kalpak Seal'
'''
The diameter of a tree T is the largest of the following quantities:

    the diameter of T's left subtree
    the diameter of T's right subtree
    the longest path between leaves that goes through the root of T (this can be computed from the heights of the subtrees of T)

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

def diameter_height_of_tree(root):
    if root is None:
        return 0, 0
    leftDia, leftHeight = diameter_height_of_tree(root.get_left())
    rightDia, rightHeight = diameter_height_of_tree(root.get_right())

    return max(leftHeight + rightHeight + 1, leftDia, rightDia), 1 + max(leftHeight, rightHeight)

def diameter_of_tree(root):
    d, _ = diameter_height_of_tree(root)
    return d

if __name__ == '__main__':
    root = BinaryTreeNode(1)

    root.left = BinaryTreeNode(2)
    root.right = BinaryTreeNode(3)

    root.left.left = BinaryTreeNode(4)
    root.left.right = BinaryTreeNode(5)

    root.right.left = BinaryTreeNode(6)
    root.right.right = BinaryTreeNode(7)

    print(diameter_of_tree(root))