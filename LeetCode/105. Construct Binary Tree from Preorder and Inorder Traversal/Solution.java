/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * Return the following binary tree:
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || preorder.length != inorder.length)
            return null;
        
        Map<Integer, Integer> iMap = new HashMap<Integer, Integer>();
        
        // cache the inorder into the map
        for(int i = 0; i < inorder.length; i++)
            iMap.put(inorder[i], i);
        
        TreeNode root = buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, iMap);
        return root;
    }
    
    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> iMap)
    {
        if(preStart > preEnd || inStart > inEnd)
            return null;
        
        TreeNode root = new TreeNode(preorder[preStart]);
        
        int rootPos = iMap.get(root.val);
        
        int leftEndIndex = rootPos - inStart;
        
        root.left = buildTree(preorder, preStart + 1, preStart + leftEndIndex, inorder, inStart, rootPos -1, iMap);
        root.right = buildTree(preorder, preStart + leftEndIndex + 1, preEnd, inorder, rootPos + 1, inEnd, iMap);
        
        return root;
    }
}