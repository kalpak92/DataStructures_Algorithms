public class StackUsingArray
{
    private int arr[];
    private int pos = 0;

    public StackUsingArray(int maxSize)
    {
        arr = new int[maxSize];
    }

    public int size()
    {
        return pos;
    }

    public boolean isEmpty()
    {
        return (pos == 0);
    }

    public int top()
    {
        return arr[pos - 1];
    }

    public void push(int elem)
    {
        arr[pos++] = elem;
    }

    public int pop()
    {
        return arr[--pos];
    }
        
    public static void main(String args[])
    {
        StackUsingArray s = new StackUsingArray(10);

        for (int i = 0; i < 10; i++)
        {
            s.push(i+1);
        }

        while (!s.isEmpty()) 
            System.out.println(s.pop());
    }
}