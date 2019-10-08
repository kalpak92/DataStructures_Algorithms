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

public class CircularLinkedListInsertion
{
    private Node head;

    public CircularLinkedListInsertion()
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
            System.out.println("Circular LinkedList is Empty");
        
        Node temp = head;

        while (temp != null)
        {
            System.out.print(temp.value + "->");
            temp = temp.next;

            if (temp == head)
            {
                break;
            }
        }
        System.out.println(head.value);
    }

    public void insertAtHead(int value)
    {
        Node newNode = new Node(value);
        //newNode.value = value;

        Node temp = head;

        if (head != null)
        {
            while(temp.next != head)
            {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }
        else
        {
            newNode.next = newNode;
        }
        head = newNode;

        System.out.println(value + " has been inserted.");
    }

    public static void main(String args[])
    {
        CircularLinkedListInsertion list = new CircularLinkedListInsertion();

        for (int i = 0; i < 10; i++)
        {
            list.insertAtHead(i);
            list.printList();
        }
    }
}