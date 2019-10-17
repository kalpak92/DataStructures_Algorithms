__author__='Kalpak Seal'
'''
The height of a node is the number of edges on the longest path from the node to a leaf.
A leaf node will have a height of 0.
'''
class BinaryTreeNode:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

    def setData(self, data):
        self.data = data

    def get_data(self):
        return self.data

    def get_left(self):
        return self.left

    def get_right(self):
        return self.right

def height_of_tree_recursive(root):
    if root is None:
        return -1
    return max(height_of_tree_recursive(root.get_left()), height_of_tree_recursive(root.get_right())) + 1

def height_of_tree_iterative(root):
    if root is None:
        return 0
    q = []
    q.append([root, 0])
    temp = 0
    while len(q) != 0:
        node, depth = q.pop()
        depth = max(temp, depth)

        if node.get_left() is not None:
            q.append([node.get_left(), depth + 1])

        if node.get_right() is not None:
            q.append([node.get_right(), depth + 1])

    return depth


if __name__ == '__main__':
    root = BinaryTreeNode(1)

    root.left = BinaryTreeNode(2)
    root.right = BinaryTreeNode(3)

    root.left.left = BinaryTreeNode(4)
    root.left.right = BinaryTreeNode(5)

    root.right.left = BinaryTreeNode(6)
    root.right.right = BinaryTreeNode(7)

    print ("Using Recursion: ")
    print ("Height of the tree is : ", height_of_tree_recursive(root))

    print ("Using Iterative method: ")
    print ("Height of the tree is : ", height_of_tree_iterative(root))