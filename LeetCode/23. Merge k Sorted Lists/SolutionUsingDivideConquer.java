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

class SolutionUsingDivideConquer {
    
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) 
    {
        ListNode h = new ListNode(0);
        ListNode ans = h;
    
        while (l1 != null && l2 != null) 
        {
            if (l1.val < l2.val) 
            {   
                h.next = l1;
                h = h.next;
                l1 = l1.next;
            } 
            else {
                h.next = l2;
                h = h.next;
                l2 = l2.next;
            }
        }
        
        if(l1 == null)
            h.next = l2;

        if(l2 == null)
            h.next=l1;
        
        return ans.next;
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)
            return null;
        
        int interval = 1;
        while(interval < lists.length)
        {
            for(int i = 0; i + interval < lists.length; i = i + interval*2)
                lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
            
            interval *= 2;
        }
        return lists[0];
    }
}