#include <stdio.h>
#include <stdlib.h>
 
struct Node{
	int data;
	struct Node* next;
};
 
void insert_at_beginning(struct Node** head_ref, int data){
	struct Node* new_node = (struct Node*)malloc(sizeof(struct Node));
	struct Node* current = *head_ref;
 
	new_node->data = data;
	new_node->next = *head_ref;
 
	//If linked list in not NULL
	if (*head_ref != NULL){
		while (current->next != *head_ref){
			current = current->next;
		}
		current->next = new_node;
	}
	else{
		new_node->next = new_node;
	}
 
	//Set the head node
	*head_ref = new_node;
}
 
void print_circular_linked_list(struct Node* head_ref){
	struct Node* current = head_ref;
	if (head_ref != NULL){
		do{
			printf("%d ",current->data);
			current=current->next;
		}while(current != head_ref);
		printf("\n");
	}
}
 
 
int main(void) {
	struct Node* head = NULL;
	insert_at_beginning(&head, 1);
	insert_at_beginning(&head, 2);
	insert_at_beginning(&head, 3);
	insert_at_beginning(&head, 4);
	insert_at_beginning(&head, 5);
	insert_at_beginning(&head, 6);
 
	print_circular_linked_list(head);
 
	return 0;
}
