/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 * 
 * Example:
 * Given linked list: 1->2->3->4->5, and n = 2.
 * 
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 *
 * Follow up:
 *
 * Could you do this in one pass?
 */

#include <iostream>
using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        if (head == NULL || n < 1)
            return NULL;
        
        ListNode dummy(-1);
        dummy.next = head;
        
        ListNode* lead = &dummy;
        ListNode* trail = &dummy;
        
        int count = 0;
        while (count < n)
        {
            lead = lead->next;
            count++;
        }
        
        while(lead->next != NULL)
        {
            trail = trail->next;
            lead = lead->next;
        }
        
        trail->next = trail->next->next;
        return dummy.next;

    }
};