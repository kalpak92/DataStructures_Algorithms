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

#include <iostream>
#include <stack>
using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};


class Solution {
public:
    bool isPalindrome(ListNode* head) {
        if (head == NULL || head->next == NULL)
            return true;
        
        stack<int> data;
        
        ListNode* slow = head;
        ListNode* fast = head;
        
        while(fast != NULL && fast->next != NULL)
        {
            data.push(slow->val);
            slow = slow->next;
            fast = fast->next->next;
        }
        
        if (fast != NULL)
            slow = slow->next;
        
        while(slow != NULL)
        {
            if (data.top() != slow->val)
                return false;
            
            data.pop();
            slow = slow->next;
        }
        
        return true;
    }
};