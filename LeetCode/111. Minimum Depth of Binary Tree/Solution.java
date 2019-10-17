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

 /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;

        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);

        return (leftDepth == 0 || rightDepth == 0) ? (leftDepth + rightDepth + 1) : Math.min(leftDepth, rightDepth) + 1;
    }
}
