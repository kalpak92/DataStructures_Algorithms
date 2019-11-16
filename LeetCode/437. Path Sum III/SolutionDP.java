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
  * The prefix stores the sum from the root to the current node in the recursion
  
  * The map stores <prefix sum, frequency> pairs before getting to the current node. We can imagine a path from the root to the current node. 
    The sum from any node in the middle of the path to the current node = the difference between the sum from the root to the current node and the prefix sum of the node in the middle.
    
  * We are looking for some consecutive nodes that sum up to the given target value, which means the difference discussed in 2. should equal to the target value. 
    In addition, we need to know how many differences are equal to the target value.
  
  * Here comes the map. The map stores the frequency of all possible sum in the path to the current node. 
    If the difference between the current sum and the target value exists in the map, there must exist a node in the middle of the path, such that from this node to the current node, the sum is equal to the target value.
    
  * Note that there might be multiple nodes in the middle that satisfy what is discussed in 4. The frequency in the map is used to help with this.
  
  * Therefore, in each recursion, the map stores all information we need to calculate the number of ranges that sum up to target. 
    Note that each range starts from a middle node, ended by the current node.
  
  * To get the total number of path count, we add up the number of valid paths ended by EACH node in the tree.
  
  * Each recursion returns the total count of valid paths in the subtree rooted at the current node. And this sum can be divided into three parts:
        - the total number of valid paths in the subtree rooted at the current node's left child
        - the total number of valid paths in the subtree rooted at the current node's right child
        - the number of valid paths ended by the current node
        
    The interesting part of this solution is that the prefix is counted from the top(root) to the bottom(leaves), and the result of total count is calculated from the bottom to the top
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
        if (root == null) 
        {
            return 0;
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        return findPathSum(root, 0, sum, map);  
    }
    
    private int findPathSum(TreeNode curr, int sum, int target, Map<Integer, Integer> map) 
    {
        if (curr == null) 
        {
            return 0;
        }
        
        // update the prefix sum by adding the current val
        sum += curr.val;
        
        // get the number of valid path, ended by the current node
        int numPathToCurr = map.getOrDefault(sum-target, 0); 
        
        // update the map with the current sum, so the map is good to be passed to the next recursion
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        
        // add the 3 parts discussed in 8. together
        int res = numPathToCurr + findPathSum(curr.left, sum, target, map) + findPathSum(curr.right, sum, target, map);

        // restore the map, as the recursion goes from the bottom to the top
        map.put(sum, map.get(sum) - 1);
        
        return res;
    }
}