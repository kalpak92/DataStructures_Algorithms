/**
 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
 * 
 * Note:
 * Given target value is a floating point.
 * 
 * You are guaranteed to have only one unique value in the BST that is closest to the target.
 * Example:
 * Input: root = [4,2,5,1,3], target = 3.714286
 *     4
 *    / \
 *   2   5
 *  / \
 * 1   3
 * 
 * Output: 4
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
    public int closestValue(TreeNode root, double target) {
        int value, result = root.val;
        
        while(root != null)
        {
            value = root.val;
            result = Math.abs(value - target) < Math.abs(result - target) ? value : result; // update result if the difference between current root and target is smaller
            
            root = target < root.val ? root.left : root.right;
        }
        
        return result;
    }
}