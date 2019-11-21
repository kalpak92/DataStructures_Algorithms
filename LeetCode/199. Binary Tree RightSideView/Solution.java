/**
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 * 
 * Example:
 * Input: [1,2,3,null,5,null,4]
 * Output: [1, 3, 4]
 * 
 * Explanation:
 * 
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
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
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null)
            return new ArrayList<Integer>();
        
        List<Integer> result = new ArrayList<>();
        
        Queue<TreeNode> level = new LinkedList<>();
        
        level.offer(root);
        
        // Do a level order traversal. Only the last element in the queue will go to the result array.
        while(!level.isEmpty())
        {
            int size = level.size();
            
            for(int i = 0; i < size; i++)
            {
                TreeNode current = level.poll();
                if(i == size - 1)
                {
                    result.add(current.val);
                }
                
                if(current.left != null)
                    level.offer(current.left);
                if(current.right != null)
                    level.offer(current.right);
            }      
        }
        
        return result;
    }
}