/**
 * Given an n-ary tree, return the preorder traversal of its nodes' values.
 * For example, given a 3-ary tree:
 *                  1
 *          3       2       4
 *      5       6
 * 
 * Return its preorder traversal as: [5,6,3,2,4,1].
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
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> result = new LinkedList<>();
        
        if (root == null)
            return result;
        
        Stack<Node> s = new Stack<>();
        s.push(root);
        
        while(!s.isEmpty())
        {
            Node current = s.pop();
            result.addFirst(current.val);       // add to the start of the linked list or an arrayList, using add(pos, element)
            
            for(Node c : current.children)
                s.push(c);
        }
        
        return result;
    }
}