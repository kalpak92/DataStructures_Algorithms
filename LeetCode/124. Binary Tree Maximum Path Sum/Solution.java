/**
 * Given a non-empty binary tree, find the maximum path sum.
 * 
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
 * 
 * Example 1:
 * 
 * Input: [1,2,3]
 * 
 *        1
 *       / \
 *      2   3
 * 
 * Output: 6
 * 
 * Example 2:
 * 
 * Input: [-10,9,20,null,null,15,7]
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 
 * Output: 42
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
    int max = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        pathSum(root);
        return max;
    }
    
    private int pathSum(TreeNode root)
    {
        if (root == null)
            return 0;
        
        int left = Math.max(0, pathSum(root.left));
        int right = Math.max(0, pathSum(root.right));
        
        // maxValue is the value which is recording whether this current root is the final root, so we use left + right + node.val.
        max = Math.max(max, root.val + left + right);
        
        // But to the upper layer (after return statement),
        // we cannot choose both left and right brunches, so we need to select the larger one, so we use max(left, right) + node.val to prune the lower brunch.
        return Math.max(left, right) + root.val;
    }
}