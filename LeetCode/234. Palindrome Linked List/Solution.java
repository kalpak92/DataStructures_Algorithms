/**
 * Given a singly linked list, determine if it is a palindrome.
 * Example 1:
 * 
 * Input: 1->2
 * Output: false
 * Example 2:
 * 
 * Input: 1->2->2->1
 * Output: true
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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
            
        Stack<Integer> data = new Stack<Integer>();
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null)
        {
            data.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // handles the case when there is an odd number of elements.
        // The middle element is required to be alone, so no need to pump it into the stack.
        // fast will not be null for odd number of elements since we are incrementing it by 2.
        
        if (fast != null)
            slow = slow.next;
        
        while(slow != null)
        {
            if(data.pop() != slow.val)
                return false;
            
            slow = slow.next;
        }
        
        return true;
        
    }
}