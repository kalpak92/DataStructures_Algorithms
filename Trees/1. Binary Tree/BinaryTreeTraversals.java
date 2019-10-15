public class BinaryTreeTraversals
{
    public void preOrder(BinaryTreeNode root)
    {
        if (root != null)
        {
            System.out.println(root.getData());
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
    } 
}