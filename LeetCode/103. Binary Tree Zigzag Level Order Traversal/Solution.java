/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 * 
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 
 * return its zigzag level order traversal as:
 * 
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result  = new ArrayList<List<Integer>>();
        
        if (root == null)
            return result;
        
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        
        s1.push(root);
        
        while(!s1.isEmpty() || !s2.isEmpty())
        {
            List<Integer> l1 = new ArrayList<Integer>();
            List<Integer> l2 = new ArrayList<Integer>();
            while(!s1.isEmpty())
            {
                TreeNode current = s1.pop();
                l1.add(current.val);
                
                if(current.left != null)
                    s2.push(current.left);
                
                if(current.right != null)
                    s2.push(current.right);
            }
            
            result.add(l1);
            
            while(!s2.isEmpty())
            {
                TreeNode current = s2.pop();
                l2.add(current.val);
                
                if(current.right != null)
                    s1.push(current.right);
                
                if(current.left != null)
                    s1.push(current.left);
            }
            if(!l2.isEmpty())
                result.add(l2);
        }
        
        return result;
    }
}