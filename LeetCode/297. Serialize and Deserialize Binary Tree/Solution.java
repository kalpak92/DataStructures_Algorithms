/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 * 
 * Design an algorithm to serialize and deserialize a binary tree. 
 * There is no restriction on how your serialization/deserialization algorithm should work. 
 * You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 * 
 * Example: 
 * 
 * You may serialize the following tree:
 * 
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 * 
 * as "[1,2,3,null,null,4,5]"
 * 
 * Clarification: The above format is the same as how LeetCode serializes a binary tree. 
 * You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 * 
 * Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
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
public class Codec {
    
    private static final String NULL = "X";
    private static final String DELIMIT = ",";
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return NULL + DELIMIT;
        
        String leftSerialize = serialize(root.left);
        String rightSerialize = serialize(root.right);
        
        return root.val + DELIMIT + leftSerialize + rightSerialize;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> nodesToSerialize = new LinkedList<>();
        
        nodesToSerialize.addAll(Arrays.asList(data.split(DELIMIT))); //split with the comma's
        
        return deserializeHelper(nodesToSerialize);
    }
    
    private TreeNode deserializeHelper(Queue<String> nodesToSerialize)
    {
        String valueForNode = nodesToSerialize.poll();
    
        if (valueForNode.equals(NULL)) {
          return null;
        }

        TreeNode newNode = new TreeNode(Integer.valueOf(valueForNode));
        
        newNode.left = deserializeHelper(nodesToSerialize);
        newNode.right = deserializeHelper(nodesToSerialize);
        
        return newNode;
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));