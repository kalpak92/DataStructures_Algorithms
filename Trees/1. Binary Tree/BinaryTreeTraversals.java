import java.util.*;

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
    
    public void inOrder(BinaryTreeNode root)
    {
        if (root != null)
        {
            inOrder(root.getLeft());
            System.out.println(root.getData());
            inOrder(root.getRight());
        }
    }

    public void postOrder(BinaryTreeNode root)
    {
        if (root != null)
        {
            postOrder(root.getLeft());
            postOrder(root.getRight());
            System.out.println(root.getData());
        }
    }

    public void preOrderIterative(BinaryTreeNode root)
    {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null)
            return;
        
        Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
        s.push(root);

        while(!s.isEmpty())
        {
            BinaryTreeNode temp = s.pop();
            result.add(temp.getData());

            if(temp.getRight() != null)
                s.push(temp.getRight());
            
            if(temp.getLeft() != null)
                s.push(temp.getLeft());
        }

        for(int i : result)
            System.out.println(i);
    }

    public void inOrderIterative(BinaryTreeNode root)
    {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<BinaryTreeNode> s = new Stack<>();

        BinaryTreeNode current = root;
        boolean done = false;

        while(!done)
        {
            if(current != null)
            {
                s.push(current);
                current = current.getLeft();
            }
            else{
                if(s.isEmpty())
                    done = true;
                
                else{
                    current = s.pop();
                    result.add(current.getData());
                    current = current.getRight();
                }
            }
        }

        for (int i: result)
            System.out.println(i);
    }
}