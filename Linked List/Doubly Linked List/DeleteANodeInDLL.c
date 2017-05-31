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

void delete_a_node(struct DLLNode** head_ref, int data){
	struct DLLNode* current_node = *head_ref;
	
	//if head node is to be deleted
	if (current_node!= NULL && current_node->data == data){
		*head_ref = current_node->next;
		current_node->next->prev = NULL;
		free(current_node);
		return;
	}
	
	while (current_node != NULL && current_node->data != data){
		current_node = current_node->next;
	}
	
	if (current_node->next != NULL){
		struct DLLNode* prev = current_node->prev;
		prev->next = current_node->next;
		current_node->next->prev = prev;
	}
	else{
		current_node->prev->next = NULL;
	}

	free(current_node);
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
	insert_at_beginning(&head, 2);
	insert_at_beginning(&head, 7);
	
	print_dll(head);
	
	delete_a_node(&head, 7);
	print_dll(head);
	
	return 0;
}
