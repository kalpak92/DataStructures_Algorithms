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

struct Node* sorted_merge(struct Node* head1, struct Node* head2){
	struct Node* result = NULL;
	
	if (head1 == NULL)
		return head2;
	
	if (head2 == NULL)
		return head1;
		
	if (head1->data < head2->data){
		result = head1;
		result->next = sorted_merge(head1->next, head2);
	}
	else{
		result = head2;
		result->next = sorted_merge(head1, head2->next);
	}
	
	return result;
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
	struct Node* head1 = NULL;
    insert_at_end(&head1, 1);
    insert_at_end(&head1, 3);
    insert_at_end(&head1, 5);
    insert_at_end(&head1, 7);
    insert_at_end(&head1, 9);
    
    printLinkedList(head1);
    
    struct Node* head2 = NULL;
    insert_at_end(&head2, 2);
    insert_at_end(&head2, 4);
    insert_at_end(&head2, 6);
    insert_at_end(&head2, 8);
    insert_at_end(&head2, 10);
    
    printLinkedList(head2);
    
    struct Node* result = sorted_merge(head1, head2);
    printLinkedList(result);
    
	return 0;
}