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

maxData = float("-infinity")
def find_maximum_in_tree(root):
    global maxData
    if not root:
        return maxData

    if root.get_data() > maxData:
        maxData = root.get_data()

    find_maximum_in_tree(root.get_left())
    find_maximum_in_tree(root.get_right())

    return maxData

if __name__ == '__main__':
    root = BinaryTreeNode(1)

    root.left = BinaryTreeNode(2)
    root.right = BinaryTreeNode(3)

    root.left.left = BinaryTreeNode(4)
    root.left.right = BinaryTreeNode(5)

    root.right.left = BinaryTreeNode(6)
    root.right.right = BinaryTreeNode(7)

    print(find_maximum_in_tree(root))
    