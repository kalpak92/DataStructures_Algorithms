import java.util.*;

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

public class LowestCommonAncestor
{
    public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q)
    {
        if (root == null)
            return null;

        if (root == p || root == q)
            return root;

        TreeNode left = LCA(root.left, p, q);
        TreeNode right = LCA(root.right, p, q);

        if (left == null && right == null)
            return null;

        if (left != null && right != null)
            return root;
        
        return (left != null) ? left : right;
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

        LowestCommonAncestor obj = new LowestCommonAncestor();

        System.out.println(obj.LCA(node, node3, node6).val);
        System.out.println(obj.LCA(node, node2, node8).val);
        System.out.println(obj.LCA(node, node3, node6).val);
        System.out.println(obj.LCA(node, node2, node4).val);
    }
}