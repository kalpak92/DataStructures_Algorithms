import java.util.EmptyStackException;

/**
 * CTCI :   Describe how you could use a single array to implement three stacks
 */

 public class ThreeInOne
 {
    int stackSize;
    int stack[];
    int stackPointer[] = {-1, -1, -1};

    public ThreeInOne()
    {
        this.stackSize = 100;
        this.stack = new int[stackSize * 3];
    }

    public int absoluteIndex(int stackNum)
    {
        return (stackNum * stackSize + stackPointer[stackNum]);
    }

    public boolean isEmpty(int stackNum)
    {
        if(stackPointer[stackNum] == -1)
            return true;
        else
            return false;
    }

    public void push(int stackNum, int val)
    {
        if (stackPointer[stackNum] + 1 >= stackSize)
            throw new RuntimeException("Stack is Full.");

        stackPointer[stackNum]++ ;
        stack[absoluteIndex(stackNum)] = val;
    }

    public int pop(int stackNum)
    {
        if (isEmpty(stackNum))
            throw new EmptyStackException();
        
        int value = stack[absoluteIndex(stackNum)];
        stack[absoluteIndex(stackNum)] = 0;         // clear the entry
        stackPointer[stackNum]--;
        return value;
    }

    public int peek(int stackNum)
    {
        if (isEmpty(stackNum))
            throw new EmptyStackException();
        
        int value = stack[absoluteIndex(stackNum)];
        return value;
    }
    
    public static void main(String args[])
    {
        ThreeInOne stack = new ThreeInOne();

        for (int i = 0; i < 20; i++)
        {
            stack.push(0, i+1);
            stack.push(1, i+100);
            stack.push(2, i+200);
        }

        while(!stack.isEmpty(0))
        {
            System.out.print(stack.pop(0) + " ");
        }
        System.out.println();
        while(!stack.isEmpty(1))
        {
            System.out.print(stack.pop(1) + " ");
        }
        System.out.println();
        while(!stack.isEmpty(2))
        {
            System.out.print(stack.pop(2) + " ");
        }
        System.out.println();
    }
 }

