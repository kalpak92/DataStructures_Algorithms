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

public class MaxWidth
{
    public int maxWidth(BinaryTreeNode root)
    {
        if (root == null)
            return 0;

        /**
         * Traverse each node in breadth-first order, keeping track of that node's position. 
         * For each depth, the first node reached is the left-most, while the last node reached is the right-most.
         * 
         * The main idea in this question is to give each node a position value. 
         * If we go down the left neighbor, 
         *      then position -> position * 2; 
         * and if we go down the right neighbor, 
         *      then position -> position * 2 + 1. 
         * This makes it so that when we look at the position values L and R of two nodes with the same depth, the width will be R - L + 1.
         */

        Queue<BinaryTreeNode> q = new LinkedList<>();
        Queue<Integer> qindex = new LinkedList<>();

        q.offer(root);
        qindex.offer(1);

        int result = 0;

        while (!q.isEmpty())
        {
            int count = q.size();
            int start = 0, end = 0;

            for(int i = 0; i < count; i++)
            {
                BinaryTreeNode current = q.poll();
                int index = qindex.poll();

                if (i == 0)
                    start = index;      //start index for each level
                
                if (i == count-1)
                    end = index;        // end index for each level

                if (current.left != null)
                {
                    q.offer(current.left);
                    qindex.offer(2*index);
                }   

                if (current.right != null)
                {
                    q.offer(current.right);
                    qindex.offer(2*index + 1);
                }
            }

            result = Math.max(result, end-start + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        BinaryTreeNode node = new BinaryTreeNode(10);
        BinaryTreeNode node1 = new BinaryTreeNode(2);
        BinaryTreeNode node2 = new BinaryTreeNode(35);
        BinaryTreeNode node3 = new BinaryTreeNode(4);
        BinaryTreeNode node4 = new BinaryTreeNode(5);
        BinaryTreeNode node5 = new BinaryTreeNode(8);

        node.left = node1;
        node.right = node2;

        node1.left = node3;
        
        node2.right = node4;

        MaxWidth obj  = new MaxWidth();
        System.out.println(obj.maxWidth(node));
    }
}