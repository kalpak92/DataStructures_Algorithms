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
	while (head != NULL){
		printf("%d ", head -> data);
		head = head -> next;
	}
	printf("\n");
}

void printNthNodeFromEnd(struct Node* head_ref, int n){
	struct Node* main_ptr = head_ref;
	struct Node* ref_ptr = head_ref;
	
	int count = 0;
	
	if (head_ref != NULL){
		while (count < n){
			if (ref_ptr == NULL){
				printf("%d greater than no. of nodes in the linked list", n);
				return;
			}
			ref_ptr = ref_ptr->next;
			count ++;
		}
		
		while (ref_ptr != NULL){
			main_ptr = main_ptr->next;
			ref_ptr = ref_ptr-> next;
		}
		printf("Node no. %d from last is %d ",n, main_ptr->data);
	}
}

int main(void) {
	struct Node* head = NULL;
    insert_at_end(&head, 1);
    insert_at_end(&head, 2);
    insert_at_end(&head, 3);
    insert_at_end(&head, 4);
    insert_at_end(&head, 5);
    
    printLinkedList(head);
    
    printNthNodeFromEnd(head, 3);
    
	return 0;
}
