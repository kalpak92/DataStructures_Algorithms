import java.util.LinkedList;

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

public class RootToLeaf
{
    public LinkedList<String> pathFromRoot(BinaryTreeNode root)
    {
        LinkedList<String> result = new LinkedList<>();
        getPath(root, "", result);

        return result;
    }

    private void getPath(BinaryTreeNode root, String path, LinkedList<String> result)
    {
        if (root != null)
        {
            path += Integer.toString(root.val);

            if (root.left == null && root.right == null)
                result.add(path);
            else {
                path += "->";
                getPath(root.left, path, result);
                getPath(root.right, path, result);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode node = new BinaryTreeNode(1);
        BinaryTreeNode node1 = new BinaryTreeNode(2);
        BinaryTreeNode node2 = new BinaryTreeNode(3);
        BinaryTreeNode node3 = new BinaryTreeNode(4);
        BinaryTreeNode node4 = new BinaryTreeNode(5);
        BinaryTreeNode node5 = new BinaryTreeNode(6);

        node.left = node1;
        node.right = node2;

        node1.left = node3;
        node1.right = node4;
        
        node2.right = node5;

        RootToLeaf obj = new RootToLeaf();
        System.out.println(obj.pathFromRoot(node));

    }
}