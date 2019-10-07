class DLLNode
{
    int value;
    DLLNode next;
    DLLNode prev;

    DLLNode()
    {
        this.next = null;
        this.prev = null;
    }

    DLLNode(int value)
    {
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}

public class DoublyLinkedListInsertion
{
    private DLLNode head;

    public DoublyLinkedListInsertion()
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
        
        DLLNode temp = head;

        while (temp != null)
        {
            System.out.print(temp.value + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void insertAtHead(int value)
    {
        DLLNode newNode = new DLLNode(value);

        newNode.next = head;

        if (head != null)
            head.prev = newNode;
        
        head = newNode;
        System.out.println(value + " inserted." );
    }

    public void insertAtTail(int value)
    {
        DLLNode newNode = new DLLNode(value);
        
        if (isEmpty())
        {
            head = newNode;
            System.out.println(value + " inserted.");
            return;
        }

        DLLNode temp = head;
        while (temp.next != null)
        {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.prev = temp;

        System.out.println(value + " inserted.");
    }

    public static void main(String args[])
    {
        DoublyLinkedListInsertion list = new DoublyLinkedListInsertion();

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
    }
}