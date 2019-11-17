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
    
    // static delimiters to distinguish the serialized string in the future
    private static final String DELIMIT = ",";
    private static final String NULL = "X";
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // if the node is null, return NULL alongwith the delimiter
        if (root == null)
            return NULL + DELIMIT;  
        
        // recurse the same on the left and right subtree
        String leftSerialize = serialize(root.left);
        String rightSerialize = serialize(root.right);
        
        // return the current value of the node and the left and right serialized portions of the corresponding tree.
        return root.val + DELIMIT + leftSerialize + rightSerialize;
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> serializeData = new LinkedList<>();
        
        serializeData.addAll(Arrays.asList(data.split(DELIMIT)));
        
        return deserializeHelper(serializeData);
    }
    
    private TreeNode deserializeHelper(Queue<String> serializeData)
    {
        // Pop out an item from the queue.
        String nodeValue = serializeData.poll();
        
        //check if the value is null
        if (nodeValue.equals(NULL))
        {
            return null;
        }
        
        // create a node out of the value.
        TreeNode newNode = new TreeNode(Integer.valueOf(nodeValue));
        
        // call the helper to recurse over the left and right subtree.
        newNode.left = deserializeHelper(serializeData);
        newNode.right = deserializeHelper(serializeData);
        
        return newNode;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));