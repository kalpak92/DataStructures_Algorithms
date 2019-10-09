class Node { 
  
    int value; 
    Node next; 

    Node(int d) 
    { 
        value = d; 
        next = null; 
    } 
}
public class ReverseALinkedList
{
    private Node head;

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

    public void reverseLinkedList()
    {
        if (head == null)
        {
            System.out.println("Empty List. Cannot reverse!!");
            return;
        }
        
        Node prev = null;
        Node current = head;
        Node next = null;

        while(current != null)
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public static void main(String[] args) {
        ReverseALinkedList list = new ReverseALinkedList();

        for(int i = 0; i < 10; i++)
        {
            list.insertAtTail(i);
        }

        list.printList();

        list.reverseLinkedList();

        System.out.println("Reversed List: ");
        list.printList();

    }
}