#include <iostream>
#include <vector>
#include <queue>

using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};
 
class Solution {
public:
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        priority_queue<int, vector<int>, greater<int> > minHeap;
        
        for (ListNode* head: lists)
        {
            while(head != NULL)
            {
                minHeap.push(head->val);
                head = head -> next;
            }
        }
        
        ListNode head(-1);
        ListNode* current = &head;
        
        while(!minHeap.empty())
        {
            current->next = new ListNode(minHeap.top());
            minHeap.pop();
            current = current->next;
        }
        
        return head.next;
        
    }
};