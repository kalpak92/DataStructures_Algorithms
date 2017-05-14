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

def kth_smallest_element(root, k):
    s, current_node, rank = [], root, 0

    while s or current_node:
        if current_node:
            s.append(current_node)
            current_node = current_node.get_left()
        else:
            current_node = s.pop()
            rank += 1
            if rank == k:
                return current_node.get_data()
            current_node = current_node.get_right()

    return float("-infinity")

if __name__ == '__main__':
    root = BinarySearchTreeNode(7)

    root.left = BinarySearchTreeNode(5)
    root.right = BinarySearchTreeNode(9)

    root.left.left = BinarySearchTreeNode(2)
    root.left.right = BinarySearchTreeNode(6)

    root.right.left = BinarySearchTreeNode(8)
    root.right.right = BinarySearchTreeNode(10)

    print ("The kth smallest element in the BST: ", kth_smallest_element(root, 1))