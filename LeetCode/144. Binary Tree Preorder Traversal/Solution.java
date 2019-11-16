/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * 
 * Example:
 * Input: [1,null,2,3]
 * 
 *    1
 *     \
 *      2
 *     /
 *    3
 * 
 * Output: [1,2,3]
 * 
 * Follow up: Recursive solution is trivial, could you do it iteratively?
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
    public List<Integer> preorderTraversal(TreeNode root) 
    {
		List<Integer> result = new LinkedList<Integer>();
		preHelper(root, result);
		return result;
	}
	public void preHelper(TreeNode root, List<Integer> result) 
    {
		if(root == null) 
            return;
        
		result.add(root.val);
		preHelper(root.left, result);
		preHelper(root.right, result);
	}
}