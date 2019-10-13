import java.util.EmptyStackException;
import java.util.LinkedList;

public class StackUsingLinkedList
{
    private LinkedList<Integer> list = new LinkedList<>();

    public StackUsingLinkedList()
    {

    }

    public StackUsingLinkedList(int elem)
    {
        list.addLast(elem);
    }

    public int len()
    {
        return list.size();
    }

    public boolean isEmpty()
    {
        return len() == 0;
    }

    public int top()
    {
        if (isEmpty())
            throw new EmptyStackException();
        
        return list.peekLast();
    }

    public int pop()
    {
        if (isEmpty())
            throw new EmptyStackException();
        
        return list.removeLast();
    }

    public void push(int elem)
    {
        list.addLast(elem);
    }

    public static void main(String args[])
    {
        StackUsingLinkedList s = new StackUsingLinkedList();

        for (int i = 0; i < 10; i++)
        {
            s.push(i + 1);
        }

        while(!s.isEmpty())
            System.out.print(s.pop() + " ");

        System.out.println();
    }


}