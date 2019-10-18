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

public class CheckTreeMirror
{
    public boolean isMirror(BinaryTreeNode root1, BinaryTreeNode root2)
    {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;
        if (root1.val != root2.val)
            return false;
        else 
            return (isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left));
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        BinaryTreeNode left1 = new BinaryTreeNode(2);
        BinaryTreeNode right1 = new BinaryTreeNode(3);
        BinaryTreeNode left2  = new BinaryTreeNode(4);
        BinaryTreeNode right2 = new BinaryTreeNode(5);

        root.left = left1;
        root.right = right1;
        left1.left = left2;
        right1.right = right2;

        BinaryTreeNode mroot = new BinaryTreeNode(1);
        BinaryTreeNode mleft1 = new BinaryTreeNode(0);
        BinaryTreeNode mright1 = new BinaryTreeNode(3);
        BinaryTreeNode mleft2  = new BinaryTreeNode(4);
        BinaryTreeNode mright2 = new BinaryTreeNode(5);

        mroot.left = mright1;
        mroot.right = mleft1;
        mright1.left = mright2;
        mleft1.right = mleft2;


        CheckTreeMirror obj = new CheckTreeMirror();

        System.out.println(obj.isMirror(root, mroot));

    }
}