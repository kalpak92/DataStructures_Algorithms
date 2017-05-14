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

def search_element(root, data):
    found = False
    if root is None:
        return found

    current_node = root
    while current_node is not None:
        if data == current_node.get_data():
            found = True
            break
        elif data > current_node.get_data():
            current_node = current_node.get_right()
        else:
            current_node = current_node.get_left()

    return found



if __name__ == '__main__':
    root = BinarySearchTreeNode(7)

    root.left = BinarySearchTreeNode(5)
    root.right = BinarySearchTreeNode(9)

    root.left.left = BinarySearchTreeNode(2)
    root.left.right = BinarySearchTreeNode(6)

    root.right.left = BinarySearchTreeNode(8)
    root.right.right = BinarySearchTreeNode(10)

    data = int(input('Enter the number to search: '))
    print (search_element(root, data))
