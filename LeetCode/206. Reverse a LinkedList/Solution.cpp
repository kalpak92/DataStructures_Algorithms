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
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        if (head == NULL)
            return head;
        
        ListNode* prev = NULL;
        ListNode* current = head;
        ListNode* next = NULL;
        
        while(current != NULL)
        {
            next = current->next;
            current->next = prev;
            prev = current;
            current = next;
        }
        
        head = prev;
        return head;
    }
};