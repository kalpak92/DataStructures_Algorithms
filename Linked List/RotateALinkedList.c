#include <stdio.h>
#include <stdlib.h>

struct Node {
	int data;
	struct Node* next;
};

void insert_at_end(struct Node** head_ref, int data){
	struct Node* current_node = *head_ref;
 
	struct Node* new_node = (struct Node*)malloc(sizeof(struct Node));
	new_node->data = data;
	new_node->next = NULL;
 
	if (*head_ref == NULL){
		*head_ref = new_node;
		return;
	}
 
	while(current_node->next != NULL){
		current_node = current_node->next;
	}
 
	current_node->next = new_node;
	return;
 
}

void printLinkedList(struct Node* head){
	
	if (head == NULL)
		printf("Linked List is Empty\n");
		
	while (head != NULL){
		printf("%d ", head -> data);
		head = head -> next;
	}
	printf("\n");
}

void rotate_a_linkedlist(struct Node** head_ref, int key){
	if (key == 0)
		return;
	
	struct Node* current = *head_ref;
	int count = 1;
	
	while (count < key && current != NULL){
		current = current->next;
		count ++;
	}
	
	if (current == NULL)
		return;
		
	struct Node* kthNode = current;
	
	while (current->next != NULL){
		current = current->next;
	}
	
	/*
	To rotate the linked list, we need to change next of kth node to NULL, 
	next of last node to previous head node, and finally change head to (k+1)th node. 
	So we need to get hold of three nodes: kth node, (k+1)th node and last node.
	*/
	
	current->next = *head_ref;
	*head_ref = kthNode->next;
	kthNode->next = NULL;
}

int main(void) {
	struct Node* head = NULL;
    insert_at_end(&head, 1);
    insert_at_end(&head, 3);
    insert_at_end(&head, 5);
    insert_at_end(&head, 7);
    insert_at_end(&head, 9);
    
    printLinkedList(head);
    
    rotate_a_linkedlist(&head, 3);
    printf("After rotating the linked list\n");
    
    printLinkedList(head);
    
	return 0;
}