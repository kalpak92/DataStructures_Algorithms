/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * 
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *    3
 *   / \
 *  9  20
 *     /  \
 *    15   7
 * 
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if (root == null)
            return result;
        
        Queue<TreeNode> q = new LinkedList<>();
        
        q.offer(root);
        
        while(!q.isEmpty())
        {
            ArrayList<Integer> level = new ArrayList<>();
            int level_size = q.size();
            
            TreeNode temp;
            
            for (int i = 0; i < level_size; i++)
            {
                temp = q.poll();
                
                if (temp.left != null)
                    q.offer(temp.left);
                
                if (temp.right != null)
                    q.offer(temp.right);
                
                level.add(temp.val);
            }
            result.add(level);
        }
        return result;
    }
}