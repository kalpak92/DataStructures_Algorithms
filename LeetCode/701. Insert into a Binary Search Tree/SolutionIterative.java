/**
 * Given the root node of a binary search tree (BST) and a value to be inserted into the tree, insert the value into the BST. 
 * Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.
 * 
 * Note that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.
 * For example, 
 * Given the tree:
 *         4
 *        / \
 *       2   7
 *      / \
 *     1   3
 * 
 * And the value to insert: 5
 * You can return this binary search tree:
 * 
 *          4
 *        /   \
 *       2     7
 *      / \   /
 *     1   3 5
 * 
 * This tree is also valid:
 *          5
 *        /   \
 *       2     7
 *      / \   
 *     1   3
 *          \
 *           4
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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        
        // root was null. 
        if (root == null)
            return new TreeNode(val);
        
        TreeNode current = root;
        
        while(current != null)
        {
            if (val > current.val)      // then insertion is to be in the right side of the tree
            {
                //check if right child is null. If so, insert, else, change current to current.right
                if (current.right == null)
                {
                    current.right  = new TreeNode(val);
                    break;
                }
                
                current = current.right;
            }
            else {
                // val < current.val. So go left.
                if(current.left == null)
                {
                    current.left = new TreeNode(val);
                    break;
                }
                current = current.left;
            }
        }
        return root;
    }
}