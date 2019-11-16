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
    
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null)
            return result;
        
        // add the node to the path
        path.add(root.val);
        
        // check if the node is the leaf and the path sum matches
        if(root.left == null && root.right == null && sum == root.val)
        {
            // correct path encountered. Add it to the result list.
            result.add(new ArrayList<>(path));
        }
        
        // recursively call the left and right child
        pathSum(root.left, sum - root.val);
        pathSum(root.right, sum - root.val);
        
        // remove the last node from the path list to help backtrack
        path.remove(path.size() - 1);
        
        return result;
    }
}