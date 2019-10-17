import java.util.LinkedList;
import java.util.Queue;

class BinaryTreeNode
{
    int val;
    BinaryTreeNode left;
    BinaryTreeNode right;

    BinaryTreeNode(int val)
    {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class MaxLevelSum
{
    public int maxLevelSum(BinaryTreeNode root)
    {
        if (root == null)
            return 0;

        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.offer(root);

        int maxSum = 0;

        while(!q.isEmpty())
        {
            int count = q.size();
            int running_sum = 0;

            while(count > 0)
            {
                BinaryTreeNode current = q.poll();
                running_sum += current.val;

                if(current.left != null)
                    q.offer(current.left);

                if(current.right != null)
                    q.offer(current.right);
                count --;
            }

            maxSum = Math.max(running_sum, maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        BinaryTreeNode node = new BinaryTreeNode(10);
        BinaryTreeNode node1 = new BinaryTreeNode(2);
        BinaryTreeNode node2 = new BinaryTreeNode(35);
        BinaryTreeNode node3 = new BinaryTreeNode(4);
        BinaryTreeNode node4 = new BinaryTreeNode(5);
        BinaryTreeNode node5 = new BinaryTreeNode(86);

        node.left = node1;
        node.right = node2;

        node1.left = node3;
        node1.right = node5;
        
        node2.right = node4;
        
        MaxLevelSum obj = new MaxLevelSum();
        System.out.println(obj.maxLevelSum(node));
    }
}