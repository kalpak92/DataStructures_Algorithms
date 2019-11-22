/**
 * Given two binary search trees, return True 
 * if and only if there is a node in the first tree and a node in the second tree whose values sum up to a given integer target.
 *  
 * Input: root1 = [2,1,4], root2 = [1,0,3], target = 5
 * Output: true
 * Explanation: 2 and 3 sum up to 5.
 * 
 * Input: root1 = [0,-10,10], root2 = [5,1,7,0,2], target = 18
 * Output: false
 * 
 * Constraints:
 * 
 * Each tree has at most 5000 nodes.
 * -10^9 <= target, node.val <= 10^9
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
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        if(root1 == null || root2 == null)
            return false;
        
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        
        TreeNode temp1, temp2;
        
        while(true)
        {
            while(root1 != null)
            {
                s1.push(root1);
                root1 = root1.left;
            }
            
            while(root2 != null)
            {
                s2.push(root2);
                root2 = root2.right;
            }
            
            if(s1.isEmpty() || s2.isEmpty())
                break;
            
            temp1 = s1.peek();
            temp2 = s2.peek();
            
            if(temp1.val + temp2.val == target)
                return true;
            else if(temp1.val + temp2.val < target)
            {
                s1.pop();
                root1 = temp1.right;
            }
            else {
                s2.pop();
                root2 = temp2.left;
            }
        }
        return false;
    }
}