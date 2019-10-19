/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Example:
 * 
 * Given the below binary tree and sum = 22,
 * 
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \    / \
 * 7    2  5   1
 * 
 * Return:
 * 
 * 
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
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
    
    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null)
            return result;
        
        path.add(root.val);
        
        if (root.left == null && root.right == null && sum == root.val)
            result.add(new ArrayList<>(path));                              // insert the path to the result array 
        
        pathSum(root.left, sum - root.val);
        pathSum(root.right, sum - root.val);
        
        path.remove(path.size() - 1);       // remove the element as we move up the node. **IMPORTANT**
        
        return result;
    }
}