/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 
 * Example:
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 * 
 * Output: [1,3,2]
 * 
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */

 /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * /
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        TreeNode current = root;
        
        while(current != null)
        {
            if(current.left == null)
            {
                result.add(current.val);
                current = current.right;
            }
            else
            {
                TreeNode predecessor = current.left;

                // To find predecessor keep going right until the right node node is not null or the right node is not equal to the current node
                while(predecessor.right != current && predecessor.right != null)
                {
                    predecessor = predecessor.right;
                }

                // If the right node is null, go left after establishing the link
                if (predecessor.right == null)
                {
                    predecessor.right = current;
                    current = current.left;
                }
                else {
                    // left is already visited. Go right, after visiting current.
                    predecessor.right  = null;
                    //System.out.print(current.val + " ");
                    result.add(current.val);
                    current = current.right;
                }
            }
        }   
        return result;
    }   
}