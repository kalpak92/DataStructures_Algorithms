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

def NonRecursivePreOrder(root, result):
    if not root:
        return
    stack = []
    stack.append(root)

    while stack:
        node = stack.pop()
        result.append(node.getData())

        if node.getRight():
            stack.append(node.getRight())
        if node.getLeft():
            stack.append(node.getLeft())

def NonRecursiveInOrder(root, result):
    if not root:
        return

    stack = []
    node = root

    while stack or node:
        if node:
            stack.append(node)
            node = node.getLeft()
        else:
            node = stack.pop()
            result.append(node.getData())
            node = node.getRight()

def NonRecursivePostOrder(root, result):
    if not root:
        return

    visited = set()
    stack = []
    node = root

    while stack or node:
        if node:
            stack.append(node)
            node = node.getLeft()

        else:
            node = stack.pop()
            if node.getRight() and not node.getRight() in visited:
                stack.append(node)
                node = node.getRight()
            else:
                visited.add(node)
                result.append(node.getData())
                node = None

if __name__ == '__main__':
    root = BinaryTreeNode(1)

    root.left = BinaryTreeNode(2)
    root.right = BinaryTreeNode(3)

    root.left.left = BinaryTreeNode(4)
    root.left.right = BinaryTreeNode(5)

    root.right.left = BinaryTreeNode(6)
    root.right.right = BinaryTreeNode(7)

    print("PreOder Non Recursive: ")
    result = []
    NonRecursivePreOrder(root, result)
    print (result)

    print ("InOrder Non Recursive: ")
    result = []
    NonRecursiveInOrder(root, result)
    print(result)

    print ("PostOrder Non Recursive: ")
    result = []
    NonRecursivePostOrder(root, result)
    print(result)