import java.util.LinkedList;

class Node
{
    int value;
    Node next;

    Node()
    {
        this.next = null;
    }
    Node(int value)
    {
        this.value = value;
        this.next = null;
    }
}

public class LinkedListInsertion
{
    private Node head;

    public LinkedListInsertion()
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

    public void insertAtHead(int value)
    {
        Node newNode = new Node();
        newNode.value = value;

        newNode.next = head;
        head = newNode;

        System.out.println(value + " has been inserted.");
    }

    public void insertAtTail(int value)
    {
        Node newNode = new Node(value);

        if (isEmpty())
        {
            newNode.next = head;
            head = newNode;
            System.out.println(value + " has been inserted.");
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

    public void insertAtNthPosition(int value, int position)
    {
        int count = 1;
        Node temp = head;

        while (temp.next != null && count < (position - 1))
        {
            temp = temp.next;
            count++;
        }
        if (temp != null && (count == (position-1)))
        {
            Node newNode = new Node(value);
            newNode.next = temp.next;
            temp.next = newNode;
            System.out.println(value + " has been inserted.");
        }
        
    }

    public static void main(String args[])
    {
        LinkedListInsertion list = new LinkedListInsertion();

        for (int i = 0; i < 10; i++)
        {
            list.insertAtHead(i);
            list.printList();
        }

        for (int i = 30; i > 20; i--)
        {
            list.insertAtTail(i);
            list.printList();
        }

        int position = 12;
        System.out.println("Inserting Node at position " + position);
        list.insertAtNthPosition(15, position);
        list.printList();

    }
}