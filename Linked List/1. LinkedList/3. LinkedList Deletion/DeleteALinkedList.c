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

void deleteLinkedList(struct Node** head_ref){
	struct Node* current = *head_ref;
	struct Node* next;
	
	while (current != NULL){
		next = current->next;
		free(current);
		current = next;
	}
	
	*head_ref = NULL;
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

int main(void) {
	struct Node* head = NULL;
    insert_at_end(&head, 1);
    insert_at_end(&head, 2);
    insert_at_end(&head, 3);
    insert_at_end(&head, 4);
    insert_at_end(&head, 5);
    
    printLinkedList(head);
    
    deleteLinkedList(&head);
    printLinkedList(head);
    
    
	return 0;
}