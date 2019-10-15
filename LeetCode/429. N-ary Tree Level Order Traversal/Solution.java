/**
 * Given an n-ary tree, return the preorder traversal of its nodes' values.
 * For example, given a 3-ary tree:
 *                  1
 *          3       2       4
 *      5       6
 * 
 * We should return its level order traversal
 * [
 *  [1],
 *  [3,2,4],
 *  [5,6]
 * ]
 * 
 * Note:
 * 
 * The depth of the tree is at most 1000.
 * The total number of nodes is at most 5000.
 */

 /*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (root == null)
            return result;
        
        Queue<Node> q = new LinkedList<>();
        
        q.offer(root);
        
        while(!q.isEmpty())
        {
            List<Integer> current_level = new LinkedList<>();     // store the elements of the current level
            
            // fetch each node of the current level and add the subsequent children of those nodes to the queue
            int curr_level_len = q.size();
            
            for(int i=0; i< curr_level_len; i++)
            {
                Node current = q.poll();
                current_level.add(current.val);     // add the current node to the current level list
                
                // Need to add the chilren of the current node to the queue
                for (Node c: current.children)
                {
                    q.offer(c);         
                }
            }
            
            // add the current level to the result list.
            result.add(current_level);
        }
        
        return result;
    }
}

