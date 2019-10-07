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

public class LinkedListDeletion
{
    private Node head;

    public LinkedListDeletion()
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

    public void deleteAtHead()
    {
        if (isEmpty())
        {
            System.out.println("Linked List is empty. Cannot perform delete operation.");
            return;
        }
        Node currentNode = head;
        head = head.next;
        System.out.println(currentNode.value + " has been deleted.");
        currentNode = null; // clear to let garbage collector do its work;

    }

    public void deleteANode(int value)
    {
        if (isEmpty())
        {
            System.out.println("Linked List is empty. Cannot perform delete operation.");
            return;
        }

        Node currentNode = head;
        Node prev = null;

        // if node to be deleted is the head node.
        if (currentNode != null && currentNode.value == value)
        {
            head = currentNode.next;
            System.out.println(currentNode.value + " has been deleted.");
            currentNode = null;
            return;
        }

        while (currentNode != null && currentNode.value != value)
        {
            prev = currentNode;
            currentNode = currentNode.next;
        }

        if (currentNode == null)
        {
            System.out.println("Node with value " + value +" does not exist.");
            return;
        }
        
        prev.next = currentNode.next;
        System.out.println(currentNode.value + " has been deleted.");
        currentNode = null;
        return;
        
    }

    public static void main(String args[])
    {
        LinkedListDeletion list = new LinkedListDeletion();

        for (int i = 0; i < 10; i++)
        {
            list.insertAtTail(i);
            list.printList();
        }
        System.out.println("Deleting the Head node.");
        list.deleteAtHead();
        list.printList();

        System.out.println("Deleting node with value 6.");
        list.deleteANode(6);
        list.printList();

        System.out.println("Trying to delete a node whose value does not exist");
        list.deleteANode(12);
    }

}