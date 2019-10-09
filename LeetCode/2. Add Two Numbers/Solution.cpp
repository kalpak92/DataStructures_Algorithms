/*
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * 
 * Example:
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * 
 * Explanation: 342 + 465 = 807.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
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
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode* head = new ListNode(0);
        ListNode** current = &head;
        int carry = 0;
        
        while(l1 != NULL || l2 != NULL)
        {
            int sum = carry;
            if(l1 != NULL)
            {
                sum += l1->val;
                l1 = l1->next;
            }
            
            if(l2 != NULL)
            {
                sum += l2->val;
                l2 = l2->next;
            }
            
            carry = sum/10;
            sum = sum%10;
            
            ListNode* res = new ListNode(sum);
            
            (*current)->next = res;
            current = &(*current)->next;
        }
        
        if (carry == 1)
        {
            (*current)->next= new ListNode(1);
        }
        
        return head->next;
        
    }
};