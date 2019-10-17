/**
 * Given a binary tree, you need to compute the length of the diameter of the tree. 
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree. 
 * This path may or may not pass through the root.
 * 
 * Example:
 * Given a binary tree:
 *          1
 *      2       3
 *  4       5
 * 
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 * Note: The length of path between two nodes is represented by the number of edges between them.
 */

class BinaryTreeNode
{
    int val;
    BinaryTreeNode left;
    BinaryTreeNode right;

    public BinaryTreeNode(int val)
    {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class DiameterOfTree
{
    class MaxObject
    {
        int result;
    }

    public int diameterOfBinaryTree(BinaryTreeNode root)
    {
        MaxObject max = new MaxObject();
        max.result = 0;

        maxDepth(root, max);
        return max.result;
    }

    private int maxDepth(BinaryTreeNode root, MaxObject max)
    {
        if (root == null)
            return 0;

        int left = maxDepth(root.left, max);
        int right = maxDepth(root.right, max);

        // although the longest path doesn't have to go through the root node, 
        // it has to pass the root node of some subtree of the tree (because it has to be from one leaf node to another leaf node, 
        // otherwise we can extend it for free). 
        // The longest path that passes a given node as the ROOT node is T = left_height + right_height. 
        // So you just calculate T for all nodes and output the max T.

        // Pay attention that we define - 
        //  The diameter of a binary tree is the length of the "longest path" between any two nodes in a tree in the problem, 
        // that is why we update with max = Math.max(max, left + right); instead of max = Math.max(max, left + right + 1);

        max.result = Math.max(max.result, left + right);
        
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        BinaryTreeNode node = new BinaryTreeNode(10);
        BinaryTreeNode node1 = new BinaryTreeNode(2);
        BinaryTreeNode node2 = new BinaryTreeNode(35);
        BinaryTreeNode node3 = new BinaryTreeNode(4);
        BinaryTreeNode node4 = new BinaryTreeNode(5);
        BinaryTreeNode node5 = new BinaryTreeNode(8);

        node.left = node1;
        node.right = node2;

        node1.left = node3;
        node1.right = node4;

        node2.right = node5;

        DiameterOfTree diam = new DiameterOfTree();

        System.out.println(diam.diameterOfBinaryTree(node));
    }
}