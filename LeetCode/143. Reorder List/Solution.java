/********************************************************************************** 
* 
* Given a singly linked list L: L0→L1→…→Ln-1→Ln,
* reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
* 
* You must do this in-place without altering the nodes' values.
* 
* For example,
* Given {1,2,3,4}, reorder it to {1,4,2,3}.
* 
*               
**********************************************************************************/

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head .next == null)
            return;
        
        // Let's find the middle of the linked list
        ListNode p1 = head;
        ListNode p2 = head;
        
        while (p2.next != null && p2.next.next != null )
        {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        
        // Reverse the second half
        ListNode head2 = reverse(p1.next);
        p1.next = null;
        
        
        // Link the two halves together
        while (head != null && head2 != null) 
        {
            ListNode tmp1 = head.next;
            ListNode tmp2 = head2.next;
            
            head2.next = head.next;
            head.next = head2;
            
            head = tmp1;
            head2 = tmp2;
        }
    }
    private ListNode reverse(ListNode n) 
    {
        ListNode prev = null;
        ListNode cur = n;
        while (cur != null) 
        {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return prev;
    } 
}      
    