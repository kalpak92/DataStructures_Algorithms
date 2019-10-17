/**
 * Given a binary tree, return all root-to-leaf paths.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Example:
 * Input:
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 * 
 * Output: ["1->2->5", "1->3"]
 * 
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
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
    
    public List<String> binaryTreePaths(TreeNode root) {
        LinkedList<String> paths = new LinkedList<>();
        
        getPath(root, "", paths);
        return paths;
    }
    
    private void getPath(TreeNode root, String path, LinkedList<String> paths)
    {
        if (root != null)
        {
            path += Integer.toString(root.val);
            
            // check for leaf nodes
            if ((root.left == null) && (root.right == null))
            {
                paths.add(path);        // adding the enitre path to the linkedList
            }
            else {
                path += "->";
                getPath(root.left, path, paths);
                getPath(root.right, path, paths);
            }           
        }
    }
}