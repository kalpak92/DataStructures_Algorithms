import java.io.*;

public class QueueUsingArray
{
    private int arr[];
    private int front, end;

    public QueueUsingArray(int maxsize)
    {
        this.front = 0;
        this.end = 0;
        arr = new int[maxsize];
    }

    public boolean isEmpty()
    {
        return (front == end);
    }

    public void enqueue(int val)
    {
        int len = arr.length;
        if (len == end)
        {
            System.out.println("Queue is FULL.");
            return;
        }
        arr[end++] = val;
    }

    public int dequeue()
    {
        if (isEmpty())
        {
            throw new RuntimeException("Queue is Empty.");
        }
        return (arr[front++]);
    }

    public int peek()
    {
        if (isEmpty())
            throw new RuntimeException("Queue is Empty.");
        return (arr[front]);
    }

    public static void main(String args[])
    {
        QueueUsingArray q = new QueueUsingArray(10);
        for (int i = 0; i < 10; i++)
        {
            q.enqueue(i+1);
        }

        while(!q.isEmpty())
            System.out.print(q.dequeue() + " ");
        
        System.out.println();
    }
}