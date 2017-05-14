__author__='Kalpak Seal'

class BinaryTreeNode:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

    def setData(self, data):
        self.data = data

    def getData(self):
        return self.data

    def getLeft(self):
        return self.left

    def getRight(self):
        return self.right


# A function to do inorder tree traversal
def printInorder(root):
    if root:
        # First recur on left child
        printInorder(root.left)

        # then print the data of node
        print(root.getData(), end = ' ')

        # now recur on right child
        printInorder(root.right)


# A function to do postorder tree traversal
def printPreorder(root):
    if root:
        # First print the data of node
        print(root.getData(), end=' ')

        # Then recur on left child
        printPreorder(root.left)

        # Finally recur on right child
        printPreorder(root.right)


# A function to do postorder tree traversal
def printPostorder(root):
    if root:
        # First recur on left child
        printPostorder(root.left)

        # the recur on right child
        printPostorder(root.right)

        # now print the data of node
        print(root.getData(), end= ' ')

if __name__ == '__main__':
    root = BinaryTreeNode(1)

    root.left = BinaryTreeNode(2)
    root.right = BinaryTreeNode(3)

    root.left.left = BinaryTreeNode(4)
    root.left.right = BinaryTreeNode(5)

    root.right.left = BinaryTreeNode(6)
    root.right.right = BinaryTreeNode(7)
    '''
    print (root.getData())
    print (root.left.getData())
    print (root.right.getData())
    print (root.left.left.getData())
    print (root.left.right.getData())
    print (root.right.left.getData())
    print (root.right.right.getData())
    '''

    print ("\nInorder: ")
    printInorder(root)
    print ("\nPreOrder: ")
    printPreorder(root)
    print ("\nPostOrder: ")
    printPostorder(root)
