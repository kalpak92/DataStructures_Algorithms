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

public class SearchElement
{
    public boolean searchElement(BinaryTreeNode root, int val)
    {
        // using level order traversal

        if (root == null)
            return false;

        boolean ans = false;
        
        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty())
        {
            BinaryTreeNode current = q.poll();
            if(current.data == val)
            {
                ans = true;
                return ans;
            }   
            
            if(current.left != null)
                q.offer(current.left);
            
            if(current.right != null)
                q.offer(current.right);
        }

        return ans;
    }

    public static void main(String[] args) {
        BinaryTreeNode node = new BinaryTreeNode(10);
        BinaryTreeNode node1 = new BinaryTreeNode(2);
        BinaryTreeNode node2 = new BinaryTreeNode(35);
        BinaryTreeNode node3 = new BinaryTreeNode(4);
        BinaryTreeNode node4 = new BinaryTreeNode(5);

        node.left = node1;
        node.right = node2;

        node1.left = node3;
        node1.right = node4;

        SearchElement search = new SearchElement();

        System.out.println(search.searchElement(node, 50));
    }
}