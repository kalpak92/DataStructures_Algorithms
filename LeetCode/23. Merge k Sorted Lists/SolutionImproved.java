/********************************************************************************** 
* Merge k sorted linked lists and return it as one sorted list. 
*
* Analyze and describe its complexity.
*
**********************************************************************************/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 
 */

 /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class SolutionImproved {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b)->a.val-b.val);
        
        for(ListNode head: lists)   // insert the first nodes into the priority queue.
        {
            if(head != null)
            {
                minHeap.add(head);
            }
        }
        
        ListNode head = new ListNode(-1);
        ListNode current = head;
        
        while(!minHeap.isEmpty())
        {
            ListNode temp = minHeap.poll();     // get the smallest node.
            current.next = temp;                // attach to the output list. 
            
            if(temp.next != null)               // if the node received from the priority queue is not null, add the next item of it from that list.
            {
                minHeap.add(temp.next); 
            }

            current = current.next;
        }
        
        return head.next;
    }
}