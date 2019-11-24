/**
 * Given a binary tree, flatten it to a linked list in-place.
 * 
 * For example, given the following tree:
 * 
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 
 * The flattened tree should look like:
 * 
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
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
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        
        TreeNode dummy = new TreeNode(-1);
        Stack<TreeNode> stack = new Stack<>();
        
        // DFS through the tree. So will use a stack and push the right child first, followed by the left.
        stack.push(root);
        
        while(!stack.isEmpty())
        {
            TreeNode current = stack.pop();
            
            dummy.right = current;
            dummy.left = null;          // IMPORTANT: else TLE. Because we are flattening the nodes.
            
            if(current.right != null)
                stack.push(current.right);
            
            if(current.left != null)
                stack.push(current.left);
            
            dummy = current;            // change dummy to current node.
            
        }
    }
}