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

public class DoublyLinkedListDeletion
{
    private DLLNode head;

    public DoublyLinkedListDeletion()
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

    public void deleteANode(int value)
    {
        if (isEmpty())
        {
            System.out.println("List is Empty.");
            return;
        }

        DLLNode temp = head;
        if (temp.value == value)
        {
            head = head.next;
            head.prev = null;
            System.out.println(value + " deleted.");
            return;
        }

        while (temp != null)
        {
            if(temp.value == value)
            {
                temp.prev.next = temp.next;
                if (temp.next != null)
                {
                    temp.next.prev = temp.prev;
                }
                System.out.println(value + " deleted.");
                return;
            }
            temp = temp.next;
        }

        if (temp == null)
        {
            System.out.println(value + " does not exist.");
        }
    }

    public static void main(String args[])
    {
        DoublyLinkedListDeletion list = new DoublyLinkedListDeletion();

        for (int i = 0; i < 8; i++)
        {
            list.insertAtHead(i);
            list.printList();
        }

        for (int i = 30; i > 25; i--)
        {
            list.insertAtTail(i);
            list.printList();
        }

        list.deleteANode(8);
        list.deleteANode(27);
        list.printList();
        list.deleteANode(7);
        list.printList();
    }
}