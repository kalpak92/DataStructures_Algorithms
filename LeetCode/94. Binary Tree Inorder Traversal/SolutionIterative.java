/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 
 * Example:
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 * 
 * Output: [1,3,2]
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
 * /
 */

class SolutionIterative {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        Stack<TreeNode> stack  = new Stack<>();
        TreeNode current = root;
        
        while(current != null || !stack.empty())
        {
            while(current != null)
            {
                stack.push(current);
                current = current.left;
            }
            
            current = stack.pop();
            result.add(current.val);
            current = current.right;
        }
        return result;
    }
    
}