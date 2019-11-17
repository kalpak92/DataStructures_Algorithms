/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, 
 * or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 * 
 * Design an algorithm to serialize and deserialize a binary search tree. 
 * There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary search tree can be serialized to a string and this string can be deserialized to the original tree structure.
 * The encoded string should be as compact as possible.
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
        
        String leftSubTree = serialize(root.left);
        String rightSubTree = serialize(root.right);
        
        return root.val + DELIMIT + leftSubTree + rightSubTree;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) 
    {
        if (data == null)
            return null;
        
        Queue<Integer> serializeData = new LinkedList<>();
        
        String[] nodes = data.split(DELIMIT);
        
        for(String s : nodes)
        {
            if (s.equals(NULL))
                continue;
            serializeData.offer(Integer.parseInt(s));
        }
        //serializeData.addAll(Arrays.asList(data.split(DELIMIT)));
        System.out.println(serializeData);
        
        return deserializeHelper(serializeData);
    }
    
    private TreeNode deserializeHelper(Queue<Integer> serializeData)
    {
        if (serializeData.isEmpty())
            return null;
        
        // pop out an element from the queue
        int nodeVal = serializeData.poll();
            
        // create a node out of nodeVal
        TreeNode newNode = new TreeNode(nodeVal);
               
        // create a queue comprising of the elements lesser than nodeVal, as this belongs to the leftsubtree of nodeVal
        Queue<Integer> leftSubTree = new LinkedList<>();
        
        // condition : serializeData queue is not empty and value of the 1st element of the queue is lesser than the nodeVal (which is the root)
        while(!serializeData.isEmpty() && serializeData.peek() < newNode.val)
        {
            leftSubTree.offer(serializeData.poll());
        }
        
        newNode.left = deserializeHelper(leftSubTree);
        newNode.right = deserializeHelper(serializeData);
        
        return newNode;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));