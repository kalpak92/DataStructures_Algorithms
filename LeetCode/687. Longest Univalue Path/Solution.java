/**
 * Given a binary tree, find the length of the longest path where each node in the path has the same value. 
 * This path may or may not pass through the root.
 * 
 * The length of path between two nodes is represented by the number of edges between them.
 * 
 * Example 1:
 * Input:
 *               5
 *              / \
 *             4   5
 *            / \   \
 *           1   1   5
 * 
 * Output: 2
 * 
 * Example 2:
 * Input:
 *               1
 *              / \
 *             4   5
 *            / \   \
 *           4   4   5
 * 
 * Output: 2
 * 
 * Note: The given binary tree has not more than 10000 nodes. The height of the tree is not more than 1000.
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
    int result = 0;
    
    public int longestUnivaluePath(TreeNode root) {
        if (root == null)
            return 0;
        
        helper(root);
        
        return result;
    }
    
    // Computation is done Bottoms-Up which means we process the requirement after going down to the leaf nodes.
    private int helper(TreeNode root)
    {
        if(root == null)
            return 0;
        
        // Recursively call left and right of the tree.
        int left = helper(root.left);
        int right = helper(root.right);
        
        // Now calculate the longestUnivaluePath for the left and right based on the given condition
        int leftMax = 0, rightMax = 0;
        
        if(root.left != null && root.val == root.left.val)
            leftMax += left + 1;
        
        if(root.right != null && root.val == root.right.val)
            rightMax += right + 1;
        
        result = Math.max(result, leftMax + rightMax); // update result as the sum of the length of both directions from the current node.
        
        return Math.max(leftMax, rightMax); // return back the maximum of the left and right subtree to the previous state.
    }
}