public ListNode reverseKGroup(ListNode head, int k) {
    ListNode current = head;
    int count = 0;
    
    while(current != null && count != k) {
        current = current.next;
        count++;
    }
    
    if (count == k) {
        ListNode prev = reverseKGroup(current, k);
        current = head; // recentre the current node.
        while(count > 0) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            
            count --;
        }
        head = prev;
    }
    return head;
}