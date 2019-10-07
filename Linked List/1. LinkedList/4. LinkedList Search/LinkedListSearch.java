import java.util.Random;

class Node
{
    int value;
    Node next;

    public Node()
    {
        this.next = null;
    }

    public Node(int value)
    {
        this.value = value;
        this.next = null;
    }
}

public class LinkedListSearch
{
    private Node head;

    public LinkedListSearch()
    {
        head = null;
    }

    public boolean isEmpty()
    {
        if (head == null)
            return true;
        else
            return false;
    }

    public void printList()
    {
        if (isEmpty())
            System.out.println("LinkedList is Empty");
        
        Node temp = head;

        while (temp != null)
        {
            System.out.print(temp.value + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void insertAtTail(int value)
    {
        Node newNode = new Node(value);

        if (isEmpty())
        {
            newNode.next = head;
            head = newNode;
            System.out.println(value + " has been inserted");
            return;
        }
        Node temp = head;
        while (temp.next != null)
        {
            temp = temp.next;
        }
        temp.next = newNode;
        System.out.println(value + " has been inserted.");
    }

    public boolean search(int value)
    {
        Node  temp = head;

        while (temp != null)
        {
            if (temp.value == value)
                return true;
            temp = temp.next;
        }
        temp = null;
        return false;

    }

    public static void main(String args[])
    {
        LinkedListSearch list = new LinkedListSearch();

        for (int i = 0; i < 10; i++)
        {
            list.insertAtTail(i);
            list.printList();
        }

        Random rand = new Random();
        boolean exist = false;

        for (int i = 0; i < 5; i++)
        {
            int randInt = rand.nextInt(20);
            exist = list.search(randInt);

            if (exist)
                System.out.println(randInt + " exists.");
            else
                System.out.println(randInt + " does not exist.");
        }
    }
}

