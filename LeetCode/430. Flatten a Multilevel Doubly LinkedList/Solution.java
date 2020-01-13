/**
 * You are given a doubly linked list which in addition to the next and previous pointers, 
 * it could have a child pointer, which may or may not point to a separate doubly linked list. 
 * 
 * These child lists may have one or more children of their own, and so on, to produce a multilevel data structure, as shown in the example below.
 * 
 * Flatten the list so that all the nodes appear in a single-level, doubly linked list. 
 * You are given the head of the first level of the list.
 * 
 * Example 1:
 * Input: head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 * Output: [1,2,3,7,8,11,12,9,10,4,5,6]
 * 
 * Example 2:
 * Input: head = [1,2,null,3]
 * Output: [1,3,2]
 * 
 * Explanation:
 * The input multilevel linked list is as follows:
 * 
 *   1---2---NULL
 *   |
 *   3---NULL
 * 
 * Example 3:
 * Input: head = []
 * Output: []
 * 
 * Constraints:
 * Number of Nodes will not exceed 1000.
 * 1 <= Node.val <= 10^5
 */

 /*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/
class Solution {
    public Node flatten(Node head) {
        if(head == null)
            return head;
        
        Node current = head;
        
        while(current != null)
        {
            /* CASE 1: 
             * if no child, go next 
             * */
            if(current.child == null)
            {
                current = current.next;
                continue;
            }
            
            /* CASE 2: 
             * got child, find the tail of the child and link it to p.next 
             * */
            Node temp = current.child;
            
            while(temp.next != null)
            {
                temp=temp.next;
            }
            // Reconnection 
            temp.next = current.next;
            
            if (current.next != null)
                current.next.prev = temp;
            
            // reconnect the head of the child to the current node
            current.next = current.child;
            current.child.prev = current;
            current.child = null;
        }
        return head;
    }
}

