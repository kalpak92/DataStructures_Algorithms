/**
 * Given a binary tree, write a function to get the maximum width of the given tree. The width of a tree is the maximum width among all levels. The binary tree has the same structure as a full binary tree, but some nodes are null.
 * The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the level, where the null nodes between the end-nodes are also counted into the length calculation.
 * 
 * Example 1:
 * 
 * Input: 
 *            1
 *          /   \
 *         3     2
 *        / \     \  
 *       5   3     9 
 * 
 * Output: 4
 * 
 * Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
 * Example 2:
 * 
 * 
 * Input: 
 * 
 *           1
 *          /  
 *         3    
 *        / \       
 *       5   3     
 * 
 * Output: 2
 * Explanation: The maximum width existing in the third level with the length 2 (5,3).
 * Example 3:
 * Input: 
 * 
 *           1
 *          / \
 *         3   2 
 *        /        
 *       5      
 * 
 * Output: 2
 * Explanation: The maximum width existing in the second level with the length 2 (3,2).
 * 
 * Example 4:
 * Input:
 *           1
 *          / \
 *         3   2
 *        /     \  
 *       5       9 
 *      /         \
 *     6           7
 * 
 * Output: 8
 * Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).
 * 
 * Note: Answer will in the range of 32-bit signed integer.
 * 
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

 /**
 * Traverse each node in breadth-first order, keeping track of that node's position. 
 * For each depth, the first node reached is the left-most, while the last node reached is the right-most.
 * 
 * The main idea in this question is to give each node a position value. 
 * If we go down the left neighbor, 
 *      then position -> position * 2; 
 * and if we go down the right neighbor, 
 *      then position -> position * 2 + 1. 
 * This makes it so that when we look at the position values L and R of two nodes with the same depth, the width will be R - L + 1.
 */

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> qindex = new LinkedList<>();
        
        q.offer(root);
        qindex.offer(1);
        
        int result = 0;
        
        while(!q.isEmpty())
        {
            int count = q.size();
            
            int start = 0, end = 0;
            
            for (int i = 0; i < count; i++)
            {
                TreeNode current = q.poll();
                
                int index = qindex.poll();
                
                if (i == 0)
                    start = index;      // start index for each level
                
                if (i == count - 1)
                    end = index;        // end index for each level
                
                if (current.left != null)
                {
                    q.offer(current.left);
                    qindex.offer(2*index);
                }
                
                if (current.right != null)
                {
                    q.offer(current.right);
                    qindex.offer(2*index + 1);
                }
                
            }
            result = Math.max(result, end -start + 1);
        }
        return result;
    }
}