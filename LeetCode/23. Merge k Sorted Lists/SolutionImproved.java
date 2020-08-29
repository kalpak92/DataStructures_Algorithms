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
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> (a.val - b.val));
        
        for(ListNode temp : lists) {
            if(temp != null)
                minHeap.offer(temp);
        }
        
        ListNode result = new ListNode(-1);
        ListNode current = result;
        
        while(!minHeap.isEmpty()) {
            ListNode temp = minHeap.poll();
            current.next = temp;
            
            if(temp.next != null) {
                minHeap.offer(temp.next);
            }
            
            current = current.next;
        }
        return result.next;
    }
}