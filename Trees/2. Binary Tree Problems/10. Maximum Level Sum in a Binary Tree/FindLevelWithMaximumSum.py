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

import queue

def level_with_maximum_sum(root):
    if root is None:
        return None

    q = queue.Queue()
    q.put(root)
    q.put(None)                         #To demarcate end of a level
    node = None
    level = max_level = sum = max_sum = 0

    while not q.empty():
        node = q.get()
        #If the current level is complete then compare sum and max_sum
        if node is None:
            if sum > max_sum:
                max_sum = sum
                max_level = level
            sum = 0
            #place the indicator for end of the next level at the and of the queue
            if not q.empty():
                q.put(None)
                level += 1
        else:
            sum += node.get_data()
            if node.get_left() is not None:
                q.put(node.get_left())
            if node.get_right() is not None:
                q.put(node.get_right())

    return max_level, max_sum


if __name__ == '__main__':
    root = BinaryTreeNode(1)

    root.left = BinaryTreeNode(2)
    root.right = BinaryTreeNode(3)

    root.left.left = BinaryTreeNode(4)
    root.left.right = BinaryTreeNode(5)

    root.right.left = BinaryTreeNode(6)
    root.right.right = BinaryTreeNode(7)

    max_level, max_sum = level_with_maximum_sum(root)
    print ("The Maximum level is: ", max_level, " and the maximum sum is: ", max_sum)
