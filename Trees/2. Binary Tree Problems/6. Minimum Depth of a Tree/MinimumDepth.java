/**
 * Given a binary tree, find its minimum depth.
 * 
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Example:
 *          3
 *         / \
 *        9  20
 *          /  \
 *        15   7
 * 
 *      return its minimum depth = 2.
 */

class BinaryTreeNode
{
    int data;
    BinaryTreeNode left;
    BinaryTreeNode right;

    public BinaryTreeNode(int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class MinimumDepth
{
    public int minDepth(BinaryTreeNode root)
    {
        if (root == null)
            return 0;

        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);

        return (leftDepth == 0 || rightDepth == 0) ? (leftDepth + rightDepth + 1) : Math.min(leftDepth, rightDepth) + 1;    
    }

    public static void main(String[] args) {
        BinaryTreeNode node = new BinaryTreeNode(10);
        BinaryTreeNode node1 = new BinaryTreeNode(2);
        BinaryTreeNode node2 = new BinaryTreeNode(35);
        BinaryTreeNode node3 = new BinaryTreeNode(4);
        BinaryTreeNode node4 = new BinaryTreeNode(5);

        node.left = node1;
        node.right = node2;

        node1.left = node3;
        node1.right = node4;

       MinimumDepth obj = new MinimumDepth();

        System.out.println(obj.minDepth(node));
    }
}

