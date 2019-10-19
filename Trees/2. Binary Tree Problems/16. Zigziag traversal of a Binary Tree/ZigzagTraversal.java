import java.util.*;

class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val)
    {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class ZigzagTraversal
{
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result  = new ArrayList<List<Integer>>();
        
        if (root == null)
            return result;
        
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        
        s1.push(root);
        
        while(!s1.isEmpty() || !s2.isEmpty())
        {
            List<Integer> l1 = new ArrayList<Integer>();
            List<Integer> l2 = new ArrayList<Integer>();
            while(!s1.isEmpty())
            {
                TreeNode current = s1.pop();
                l1.add(current.val);
                
                if(current.left != null)
                    s2.push(current.left);
                
                if(current.right != null)
                    s2.push(current.right);
            }
            
            result.add(l1);
            
            while(!s2.isEmpty())
            {
                TreeNode current = s2.pop();
                l2.add(current.val);
                
                if(current.right != null)
                    s1.push(current.right);
                
                if(current.left != null)
                    s1.push(current.left);
            }
            if(!l2.isEmpty())
                result.add(l2);
        }
        
        return result;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        TreeNode node1 = new TreeNode(6);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(11);
        TreeNode node5 = new TreeNode(9);
        TreeNode node6 = new TreeNode(5);
        TreeNode node7 = new TreeNode(13);
        TreeNode node8 = new TreeNode(7);

        node.left = node1;
        node.right = node2;

        node1.left = node3;
        node1.right = node4;

        node4.left = node5;
        node4.right = node6;
        
        node2.right = node7;
        node7.left = node8;

        ZigzagTraversal obj = new ZigzagTraversal();

        List<List<Integer>> result = obj.zigzagLevelOrder(node);

        System.out.println(result);
    }
}

