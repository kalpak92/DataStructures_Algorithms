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

public class MorrisTraversal
{
    public void inorder(TreeNode root)
    {
        TreeNode current = root;

        while (current != null)
        {
            if(current.left == null)
            {
                System.out.print(current.val + " ");
                current = current.right;
            }
            else {
                TreeNode predecessor = current.left;
                
                // To find predecessor keep going right until the right node node is not null or the right node is not equal to the current node
                while(predecessor.right != current && predecessor.right != null)
                {
                    predecessor = predecessor.right;
                }

                // If the right node is null, go left after establishing the link
                if (predecessor.right == null)
                {
                    predecessor.right = current;
                    current = current.left;
                }
                else {
                    // left is already visited. Go right, after visiting current.
                    predecessor.right  = null;
                    System.out.print(current.val + " ");
                    current = current.right;
                }
            }
        }
    }
}