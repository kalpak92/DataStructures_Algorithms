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
 
void delete_given_node(struct Node *given_node){
	struct Node* temp = given_node->next;
	given_node->data=temp->data;
	given_node->next= temp->next;
 
	free(temp);
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
 
    delete_given_node(head->next);
    printf("After deleting a node \n");
    printLinkedList(head);
 
	return 0;
}