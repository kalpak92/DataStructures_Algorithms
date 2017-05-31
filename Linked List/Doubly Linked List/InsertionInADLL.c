#include <stdio.h>
#include <stdlib.h>

struct DLLNode {
	int data;
	struct DLLNode* next;
	struct DLLNode* prev;
};

void insert_at_beginning(struct DLLNode** head_ref, int data){
	struct DLLNode* new_node = (struct DLLNode*)malloc(sizeof(struct DLLNode));
	new_node->data = data;
	new_node->next = (*head_ref);
	new_node->prev = NULL;
	
	if (*head_ref != NULL){
		(*head_ref)->prev = new_node;
	}
	
	*head_ref = new_node;
}

void insert_after_a_given_node(struct DLLNode* prev, int data){
	if (prev == NULL){
		printf("Previous node cannot be NULL");
		return;
	}
	
	struct DLLNode* new_node = (struct DLLNode*)malloc(sizeof(struct DLLNode));
	new_node->data = data;
	new_node->next = prev->next;
	prev->next = new_node;
	
	new_node->prev = prev;
	
	if (new_node->next != NULL){
		new_node->next->prev = new_node;
	}
}

void insert_at_end(struct DLLNode** head_ref, int data){
	struct DLLNode* new_node = (struct DLL*)malloc(sizeof(struct DLLNode));
	struct DLLNode* current = *head_ref;
	
	new_node->data = data;
	new_node->next = NULL;
	
	if (*head_ref == NULL){
		new_node->prev = NULL;
		*head_ref = new_node;
		return;
	}
	
	while (current->next != NULL){
		current = current->next;
	}
	
	current->next = new_node;
	new_node->prev = current;
}

void print_dll(struct DLLNode* head){
	struct DLLNode* current = head;
	
	while(current != NULL){
		printf("%d ", current->data);
		current = current->next;
	}
	printf("\n");
}

int main(void) {
	struct DLLNode* head = NULL;
	insert_at_beginning(&head, 1);
	insert_at_beginning(&head, 3);
	insert_after_a_given_node(head->next, 2);
	insert_at_end(&head, 6);
	
	print_dll(head);
	
	return 0;
}
