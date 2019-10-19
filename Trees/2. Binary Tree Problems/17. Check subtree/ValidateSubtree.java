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

public class ValidateSubtree
{
    public boolean checkSubtree(TreeNode s, TreeNode t)
    {
        if (s == null)
            return false;

        if (isSubtree(s, t))
            return true;

        return (checkSubtree(s.left, t) || checkSubtree(s.right, t));
    }

    private boolean isSubtree(TreeNode s, TreeNode t)
    {
        if (s == null && t == null)
            return true;

        if (s == null || t == null)
            return false;

        if (s.val != t.val)
            return false;

        return (isSubtree(s.left, t.left) && isSubtree(s.right, t.right));
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

        TreeNode snode = new TreeNode(11);
        TreeNode snode1 = new TreeNode(9);
        TreeNode snode2 = new TreeNode(5);

        snode.left = snode1;
        snode.right = snode2;

        ValidateSubtree obj = new ValidateSubtree();
        System.out.println(obj.checkSubtree(node, snode));
    }
}