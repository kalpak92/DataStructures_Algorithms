import java.util.LinkedList;

public class QueueUsingLinkedList
{
    private LinkedList<Integer> queue = new LinkedList<Integer>();
    
    public QueueUsingLinkedList(){}

    public boolean isEmpty()
    {
        return (queue.size() == 0);
    }

    public int len()
    {
        return queue.size();
    }

    public int peek()
    {
        if (isEmpty())
            throw new RuntimeException("Queue is Empty.");

        return (queue.peekFirst());
    }

    public void enqueue(int val)
    {
        queue.addLast(val);
    }

    public int dequeue()
    {
        if (isEmpty())
            throw new RuntimeException("Queue is Empty.");
        return (queue.removeFirst());
    }

    public static void main(String args[])
    {
        QueueUsingLinkedList q = new QueueUsingLinkedList();

        for (int i = 0; i < 10; i++)
        {
            q.enqueue(i + 1);
        }

        while(!q.isEmpty())
            System.out.print(q.dequeue() + " ");
        
        System.out.println();
        System.out.println(q.isEmpty());
        // System.out.println(q.peek());       // Gives an error.
    }    
}