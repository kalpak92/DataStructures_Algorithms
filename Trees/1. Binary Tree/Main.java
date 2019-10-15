import java.io.*;

public class Main{
    public static void main(String[] args) {
        BinaryTreeNode node = new BinaryTreeNode(1);
        BinaryTreeNode node1 = new BinaryTreeNode(2);
        BinaryTreeNode node2 = new BinaryTreeNode(3);
        BinaryTreeNode node3 = new BinaryTreeNode(4);
        BinaryTreeNode node4 = new BinaryTreeNode(5);
        BinaryTreeNode node5 = new BinaryTreeNode(6);
        BinaryTreeNode node6 = new BinaryTreeNode(7);

        node.setLeft(node1);
        node.setRight(node2);

        node1.setLeft(node3);
        node1.setRight(node4);

        node2.setLeft(node5);
        node2.setRight(node6);

        BinaryTreeTraversals traverse = new BinaryTreeTraversals();

        System.out.println("Pre-Order");
        traverse.preOrder(node);
        System.out.println("In-Order");
        traverse.inOrder(node);
        System.out.println("Post-Order");
        traverse.postOrder(node);
    }
}