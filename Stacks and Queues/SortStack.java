/* 
 * Write a program to sort a stack in ascending order (with biggest items on top).
 * you may use at most one additional stack to hold items, but you may not copy the
 * elements into any other data strcuture (such as an array). The stack supports the
 * folowing operations: push, pop, peek, and isEmpty 
 * 
 **/
import java.util.Stack;

public class SortStack
{
    public static Stack<Integer> sortStack(Stack<Integer> s)
    {
        Stack<Integer> result = new Stack<Integer>();

        while(!s.isEmpty())
        {
            int temp = s.pop();
            while(!result.isEmpty() && result.peek() > temp)
            {
                s.push(result.pop());
            }
            result.push(temp);
        }

        return result;
    }

    public static void main(String args[])
    {
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < 10; i++)
        {
            stack.push(i+1);
            stack.push(i-1);
        }

        Stack<Integer> result = sortStack(stack);

        while(!result.isEmpty())
        {
            System.out.print(result.pop() + " ");
        }
        System.out.println();
    }
}