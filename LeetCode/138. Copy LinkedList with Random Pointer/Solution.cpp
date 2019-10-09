/********************************************************************************** 
* 
* A linked list is given such that each node contains an additional random pointer 
* which could point to any node in the list or null.
* 
* Return a deep copy of the list.
* 
*               
**********************************************************************************/

#include <iostream>
using namespace std;

// Definition for a Node.
class Node {
public:
    int val;
    Node* next;
    Node* random;

    Node() {}

    Node(int _val) {
        val = _val;
    }
};

class Solution {
public:
    Node* copyRandomList(Node* head) {
        if (head == NULL)
            return head;
        
        Node* currentNode = head;
        
        while (currentNode != NULL)
        {
            Node* newNode = new Node(currentNode->val);
            
            newNode->next = currentNode->next;
            currentNode->next = newNode;
            currentNode = newNode->next;
        }
        
        currentNode = head;
        
        while(currentNode != NULL)
        {
            if (currentNode->random != NULL)
                currentNode->next->random = currentNode->random->next;
            else
                currentNode->next->random = NULL;
            
            currentNode = currentNode->next->next;
        }
        
        Node* list1 = head;
        Node* list2 = head->next;
        Node* cloneHead = head->next;
        
        while(list1 != NULL)
        {
            list1->next = list1->next->next;
            
            if (list2->next != NULL)
                list2->next = list2->next->next;
            
            list1 = list1->next;
            list2 = list2->next;
        }
        
        return cloneHead;
    }
};