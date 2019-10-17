import java.util.LinkedList;
import java.util.Queue;

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

public class DeepestNode
{
    public void deepestNode(BinaryTreeNode root)
    {
        if (root == null)
            return;
        
        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.offer(root);

        BinaryTreeNode temp = null;

        while(!q.isEmpty())
        {
            temp = q.poll();

            if(temp.left != null)
                q.offer(temp.left);

            if(temp.right != null)
                q.offer(temp.right);
        }
        System.out.println(temp.data);
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

        DeepestNode obj = new DeepestNode();

        obj.deepestNode(node);
    }
}