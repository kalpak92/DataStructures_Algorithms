/********************************************************************************** 
* 
* Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
* 
* If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
* 
* You may not alter the values in the nodes, only nodes itself may be changed.
* 
* Only constant memory is allowed.
* 
* For example,
* Given this linked list: 1->2->3->4->5
* 
* For k = 2, you should return: 2->1->4->3->5
* 
* For k = 3, you should return: 3->2->1->4->5
* 
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
    public ListNode reverseKGroup(ListNode head, int k) {
        int n = 0;
        
        // length of linkedlist
        for (ListNode i = head; i != null; n++, i = i.next);
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode current = head;
            
        for (ListNode prev = dummy; n >= k; n-=k)
        {
            for (int i = 1; i < k; i++)
            {
                ListNode next = current.next.next;
                current.next.next = prev.next;
                prev.next = current.next;
                current.next = next;
            }
            
            prev = current;
            current = current.next;
        }
        
        return dummy.next;
        
    }
}