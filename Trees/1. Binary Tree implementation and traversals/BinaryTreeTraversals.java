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
        
        while(current != null || s.size() > 0)
        {
            while(current != null)                  // push the left subtree before processing any node
            {
                s.push(current);
                current = current.getLeft();
            }

            current = s.pop();                     

            result.add(current.getData());

            current = current.getRight();
        }

        for (int i: result)
            System.out.println(i);
    }

    public void postOrderIterative(BinaryTreeNode root)
    {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<BinaryTreeNode> s = new Stack<>();

        if (root == null)
            return ;

        s.push(root);
        BinaryTreeNode prev = null;

        while(!s.isEmpty())
        {

            BinaryTreeNode current = s.peek();

            if (prev == null || prev.getLeft() == null || prev.getRight() == null)
            {
                if (current.getLeft() != null)
                    s.push(current.getLeft());
                
                else if (current.getRight() != null)
                {
                    s.push(current.getRight());    
                }
                else {    
                    s.pop();
                    result.add(current.getData());
                }
            }
            else if (current.getLeft() == prev)
            {
                if (current.getRight() != null)
                    s.push(current.getRight());
                else
                {
                    s.pop();
                    result.add(current.getData());
                }
            }
            else if (current.getRight() == prev) 
            {
                s.pop();
                result.add(current.getData());
            }

            prev = current;
        }

        for(int i : result)
            System.out.println(i);
    }

    public void levelOrderIterative(BinaryTreeNode root)
    {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<BinaryTreeNode> q  = new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty())
        {
            BinaryTreeNode current = q.poll();
            result.add(current.getData());

            if (current.getLeft() != null)
                q.offer(current.getLeft());

            if (current.getRight() != null)
                q.offer(current.getRight());
        }

        for (int i : result)
            System.out.println(i);

    }
}