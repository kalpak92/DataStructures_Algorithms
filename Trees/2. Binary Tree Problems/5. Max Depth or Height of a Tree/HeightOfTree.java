import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find height of it. 
 * Height of empty tree is 0 and height of below tree is 3.
 * 
 *                   1
 *              2           3
 *          4       5
 * 
 *      maxDepth('1') = max(maxDepth('2'), maxDepth('3')) + 1
 *                           = 2 + 1
 *                                 /    \
 *                               /         \
 *                             /             \
 *                           /                 \
 *                         /                     \
 *              maxDepth('2') = 1                maxDepth('3') = 1
 *                  = max(maxDepth('4'), maxDepth('5')) + 1
 *                  = 1 + 1   = 2         
 *                  /    \
 *                /        \
 *              /            \
 *            /                \
 *          /                    \
 *  maxDepth('4') = 1     maxDepth('5') = 1
 */

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

public class HeightOfTree
{
    public int heightRecursive(BinaryTreeNode root)
    {
        if (root == null)
            return 0;

        int leftDepth = heightRecursive(root.left);
        int rightDepth = heightRecursive(root.right);

        return (leftDepth > rightDepth) ? leftDepth + 1 : rightDepth + 1;
    }

    public int heightIterative(BinaryTreeNode root)
    {
        if (root == null)
            return 0;

        Queue<BinaryTreeNode> q = new LinkedList<>();

        q.offer(root);
        int height = 0;

        while(true)
        {
            int count = q.size();   // no. of nodes at the current level
            
            if(count == 0)
                return height;  
            
            height++;       // increment the height

            // remove the current nodes and add their child nodes to the queue
            while(count > 0)
            {
                BinaryTreeNode current = q.poll();
                if (current.left != null)
                    q.offer(current.left);
                
                if (current.right != null)
                    q.offer(current.right);
                
                count--;
            }
        }
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

        HeightOfTree obj = new HeightOfTree();

        System.out.println(obj.heightRecursive(node));
        System.out.println(obj.heightIterative(node));
    }
}