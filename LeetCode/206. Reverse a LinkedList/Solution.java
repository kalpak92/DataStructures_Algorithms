/**
** Reverse a singly linked list.
**
** Example:
**
** Input: 1->2->3->4->5->NULL
** Output: 5->4->3->2->1->NULL
**/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null)
        {
            return head;
        }
        
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;
        
        while (current != null)
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        head = prev;
        return head;
    }
}