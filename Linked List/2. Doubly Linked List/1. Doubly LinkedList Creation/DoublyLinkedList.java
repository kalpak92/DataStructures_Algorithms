
class DLLNode
{
    int value;
    DLLNode prev;
    DLLNode next;
    
    DLLNode()
    {
        this.prev = null;
        this.next = null;
    }

    DLLNode(int value)
    {
        this.value = value;
        this.prev = prev;
        this.next = next;
    }
}

public class DoublyLinkedList
{
    private DLLNode head;

    public DoublyLinkedList()
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

    public static void main(String args[])
    {
        DoublyLinkedList list = new DoublyLinkedList();
        System.out.println(list.isEmpty());
    }
}