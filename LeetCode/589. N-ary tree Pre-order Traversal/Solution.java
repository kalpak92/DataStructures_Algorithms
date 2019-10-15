/**
 * Given an n-ary tree, return the preorder traversal of its nodes' values.
 * For example, given a 3-ary tree:
 *                  1
 *          3       2       4
 *      5       6
 * 
 * Return its preorder traversal as: [1,3,5,6,2,4].
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
    public List<Integer> preorder(Node root) {
        ArrayList<Integer>  result = new ArrayList<>();
        
        if (root == null)
            return result;
        
        Stack<Node> s = new Stack<>();
        s.push(root);
        
        while(!s.isEmpty())
        {
            Node temp = s.pop();
            result.add(temp.val);
            
            // Always keep in mid: the order of preorder traversal is: root, left, right
            // By adding the elements from right to left to stack, with the FILO property of stack, we pop out in the order from left to right.
            for(int i = temp.children.size() - 1; i >= 0; i--)
            {
                s.push(temp.children.get(i));
            }
        }
        
        return result;
    }
}