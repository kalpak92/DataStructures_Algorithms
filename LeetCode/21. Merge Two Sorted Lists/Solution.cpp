/*
** Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
**
** Example:
**
** Input: 1->2->4, 1->3->4
** Output: 1->1->2->3->4->4
*/

#include <iostream>
using namespace std;

class Solution {
public:

    struct ListNode {
      int val;
      ListNode *next;
      ListNode(int x) : val(x), next(NULL) {}
    }

    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        ListNode* p1 = l1;
        ListNode* p2 = l2;
        
        ListNode head(0);
        ListNode* current = &head;
        
        while(p1 != NULL && p2 != NULL)
        {
            if(p1->val < p2->val)
            {
                current->next = p1;
                p1 = p1->next;
            }
            else{
                current->next = p2;
                p2 = p2->next;
            }
            current = current->next;
        }
        
        if(p1)
        {
            current->next = p1;
        }
        
        if(p2)
        {
            current->next = p2;
        }
        
        return head.next;
    }
};