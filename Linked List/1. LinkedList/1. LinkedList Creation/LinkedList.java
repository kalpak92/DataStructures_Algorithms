/**
 * This class is the nodes of the SinglyLinked List.
 * They consist of a value and a pointer to the node after them.
 */
class Node {

    int value;  // Value of the node
    Node next;  // Point to the next node

    // Contructor
    Node ()
    {
        this.next = null;
    }
    Node(int value) {
        this.value = value;
        this.next = null;
    }
}

public class LinkedList
{
    private Node head;

    public LinkedList()
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

    /*
     * Main method
     */
    public static void main(String args[])
    {
        LinkedList list = new LinkedList();
        System.out.println(list.isEmpty());
    }
}

