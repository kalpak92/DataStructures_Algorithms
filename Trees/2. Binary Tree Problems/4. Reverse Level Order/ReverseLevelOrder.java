import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class BinaryTreeNode
{
    int data;
    BinaryTreeNode left, right;

    public BinaryTreeNode(int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class ReverseLevelOrder
{
    public void reverse(BinaryTreeNode root)
    {
        // using level order traversal

        if (root == null)
            return;

        Stack<Integer> s = new Stack<>();
        
        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty())
        {
            BinaryTreeNode current = q.poll();   
            
            if(current.left != null)
                q.offer(current.left);
            
            if(current.right != null)
                q.offer(current.right);

            s.push(current.data);
        }
        
        while(!s.isEmpty())
        {
            System.out.println(s.pop());
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode node = new BinaryTreeNode(10);
        BinaryTreeNode node1 = new BinaryTreeNode(2);
        BinaryTreeNode node2 = new BinaryTreeNode(35);
        BinaryTreeNode node3 = new BinaryTreeNode(4);
        BinaryTreeNode node4 = new BinaryTreeNode(5);
        BinaryTreeNode node5 = new BinaryTreeNode(6);
        BinaryTreeNode node6 = new BinaryTreeNode(7);

        node.left = node1;
        node.right = node2;

        node1.left = node3;
        node1.right = node4;

        node2.left = node5;
        node2.right = node6;

        ReverseLevelOrder rev = new ReverseLevelOrder();

        rev.reverse(node);
    }
}