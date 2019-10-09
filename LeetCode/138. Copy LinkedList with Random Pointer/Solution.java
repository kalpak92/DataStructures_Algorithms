/********************************************************************************** 
* 
* A linked list is given such that each node contains an additional random pointer 
* which could point to any node in the list or null.
* 
* Return a deep copy of the list.
* 
*               
**********************************************************************************/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
            return head;
        
        Node currentNode = head;
        
        // Add a newnode after each node with same data
        
        while (currentNode != null)
        {
            Node newNode = new Node(currentNode.val);
            
            newNode.next = currentNode.next;
            currentNode.next = newNode;
            currentNode = newNode.next;
        }
        
        // copy the random pointer to the newly added node.
        
        currentNode = head;
        while(currentNode != null)
        {
            if (currentNode.random != null)
            {
                currentNode.next.random = currentNode.random.next;
            }
            else
                currentNode.next.random = null;
            
            currentNode = currentNode.next.next;
        }
        
        // split the list
        Node list1 = head;
        Node list2 = head.next;
        Node cloneHead = head.next;
        
        while(list1!=null)
        {
            list1.next = list1.next.next;
            if (list2.next != null)
                list2.next = list2.next.next;
            else
                list2.next = null;
            
            list1 = list1.next;
            list2 = list2.next;
        }
        return cloneHead;
    }
}