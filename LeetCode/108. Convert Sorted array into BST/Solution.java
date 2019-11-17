/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * 
 * Example:
 * Given the sorted array: [-10,-3,0,5,9],
 * 
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */

 /**
  * Implement helper function helper(left, right), which constructs BST from nums elements between indexes left and right:
            If left > right, then there is no elements available for that subtree. 
                Return None.
                
            Pick middle element:
                p = (left + right) // 2.
            
                Initiate the root: root = TreeNode(nums[p]).

            Compute recursively left and right subtrees: root.left = helper(left, p - 1), root.right = helper(p + 1, right).
            Return helper(0, len(nums) - 1).
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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return null;
        
        return helperBST(nums, 0, nums.length - 1);
    }
    
    private TreeNode helperBST(int[] nums, int low, int high)
    {
        // base case
        if (low > high)
            return null;
        
        int mid  = low + (high - low) / 2;
        
        TreeNode current = new TreeNode(nums[mid]);
        current.left = helperBST(nums, low, mid - 1);
        current.right = helperBST(nums, mid + 1, high);
        
        return current;
    }
}