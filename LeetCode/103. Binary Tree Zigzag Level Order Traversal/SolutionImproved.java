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
        LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
        
        if (root == null)
            return result;
        
        Queue<TreeNode> q = new LinkedList<>();
        boolean flag = true;
        
        TreeNode current = root;
        q.offer(current);
        while(!q.isEmpty())
        {
            int size = q.size();
            LinkedList<Integer> level = new LinkedList<Integer>();
            
            for(int i = 0; i < size; i++)
            {
                current = q.poll();
                
                if(current.left != null)
                    q.offer(current.left);
                if(current.right != null)
                    q.offer(current.right);
                
                if (flag)
                    level.addLast(current.val);
                else
                    level.addFirst(current.val);
            }
            flag = !flag;
            result.addLast(level);            
        }
        
        return result;
    }
}