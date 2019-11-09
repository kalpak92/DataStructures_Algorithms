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
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for(ListNode head: lists)
        {
            while(head != null)
            {
                minHeap.add(head.val);
                head = head.next; 
            }
        }
        
        ListNode head = new ListNode(-1);
        ListNode current = head;
        
        while(!minHeap.isEmpty())
        {
            current.next = new ListNode(minHeap.remove());
            current = current.next;
        }
        
        return head.next;
    }
}