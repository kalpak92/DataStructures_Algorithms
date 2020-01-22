/**
 * Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).
 * If two nodes are in the same row and column, the order should be from left to right.
 * 
 * Examples 1:
 * Input: [3,9,20,null,null,15,7]
 * 
 *    3
 *   /\
 * /  \
 * 9  20
 *     /\
 *    /  \
 *   15   7 
 * 
 *  Output:
 * [
 *   [9],
 *   [3,15],
 *   [20],
 *   [7]
 * ]
 * 
 * Examples 2:
 * Input: [3,9,8,4,0,1,7]
 *      3
 *     /\
 *    /  \
 *    9   8
 *   /\  /\
 *  /  \/  \
 *  4  01   7 
 * 
 * Output:
 * [
 *   [4],
 *   [9],
 *   [3,0,1],
 *   [8],
 *   [7]
 * ]
 * 
 * Examples 3:
 * Input: [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5)
 *      3
 *     /\
 *    /  \
 *    9   8
 *   /\  /\
 *  /  \/  \
 *  4  01   7
 *     /\
 *    /  \
 *    5   2
 * 
 * Output:
 * [
 *   [4],
 *   [9,5],
 *   [3,0,1],
 *   [8,2],
 *   [7]
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

 /**
  *  - BFS, put node, col into queue at the same time
  *  - Every left child access col - 1 while right child col + 1
  *  - This maps node into different col buckets
  *  - Get col boundary min and max on the fly
  *  - Retrieve result from cols
  */

class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        
        List<List<Integer>> result = new ArrayList<>();
        
        Map <Integer, ArrayList<Integer>> map = new HashMap<>();
        
        Queue<TreeNode> bfs = new LinkedList<>();
        Queue<Integer> column = new LinkedList<>();
        
        bfs.offer(root);
        column.offer(0);
        
        int colmin = 0;
        int colmax = 0;
        
        while(!bfs.isEmpty())
        {
            TreeNode current = bfs.poll();
            int tempcol = column.poll();
            
            map.putIfAbsent(tempcol, new ArrayList<Integer>());
            
            map.get(tempcol).add(current.val);
            
            if(current.left != null)
            {
                bfs.offer(current.left);
                column.offer(tempcol - 1);
                
                colmin = Math.min(colmin, tempcol - 1);
            }
            
            if(current.right != null)
            {
                bfs.offer(current.right);
                column.offer(tempcol + 1);
                
                colmax = Math.max(colmax, tempcol + 1);
            }
            
        }
        
        for(int i = colmin; i <= colmax; i++)
        {
            result.add(map.get(i));
        }
        
        return result;
    }
}