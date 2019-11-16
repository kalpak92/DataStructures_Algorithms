/**
 * You are given a binary tree in which each node contains an integer value.
 * Find the number of paths that sum to a given value.
 * 
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 * 
 * Example:
 * 
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 * 
 * Return 3. The paths that sum to 8 are:
 * 
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 */

 /**
  * Time Complexity:
        1st layer DFS will always take O(n), because we will take each node out.
        2nd layer DFS will take range from O(n) (single sided tree) to O(log n)(balanced tree). 
        This is due to here we are get all the paths from a given node. The length of path is proportional to the tree height.
        Therefore, the total time complexity is O(nlogn) to O(n^2).
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
    public int pathSum(TreeNode root, int sum) {
        // base case
        if (root == null)
            return 0;
        
        return pathSumDfs(root, sum, 0) + pathSum(root.left, sum) + pathSum(root.right, sum); //  recursively traverse each node.
    }
    
    // function to walk all the paths for each node and check if the path sum meets the target.
    private int pathSumDfs(TreeNode root, int sum, int current)
    {
        if (root == null)
            return 0;
        
        current += root.val;
        
        return ((current == sum) ? 1 : 0 ) + pathSumDfs(root.left, sum, current) + pathSumDfs(root.right, sum, current);
    }
}