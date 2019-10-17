/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * 
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * 
 * Find the total sum of all root-to-leaf numbers.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Example:
 * 
 *  Input: [1,2,3]
 *        1
 *       / \
 *      2   3
 *  Output: 25
 *  Explanation:
 *      The root-to-leaf path 1->2 represents the number 12.
 *      The root-to-leaf path 1->3 represents the number 13.
 *      Therefore, sum = 12 + 13 = 25.
 * 
 * Example 2:
 *
 * Input: [4,9,0,5,1]
 *      4
 *     / \
 *    9   0
 *   / \
 *  5   1
 * 
 *  Output: 1026
 *  Explanation:
 *      The root-to-leaf path 4->9->5 represents the number 495.
 *      The root-to-leaf path 4->9->1 represents the number 491.
 *      The root-to-leaf path 4->0 represents the number 40.
 *      Therefore, sum = 495 + 491 + 40 = 1026.
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
    public int sumNumbers(TreeNode root) {
        //ArrayList<Integer> pathSum = new ArrayList<>();

        return calc(root, 0);
        
        /*
        int result = 0;
        
        for (int i : pathSum)
            result += i;
        
        return result;
        */
        
    }
    
    private int calc(TreeNode root, int pathSum)
    {
        if (root != null)
        {
            //path += root.val;
            
            if (root.left == null && root.right == null)
            {
                //pathSum.add(path);
                return pathSum*10 + root.val;
            }
            else{
                //pathSum *= 10;
                return calc(root.left, pathSum*10 + root.val) + calc(root.right, pathSum*10 + root.val);
            }
        }
        else
            return 0;
    }
}

