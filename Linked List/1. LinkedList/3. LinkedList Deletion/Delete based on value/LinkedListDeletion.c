#include <stdio.h>
#include <stdlib.h>
 
struct Node{
        int data;
        struct Node *next;
};
 
void insert_at_beginning(struct Node** head_ref, int data){
        struct Node* new_node = (struct Node*)malloc(sizeof(struct Node));
        new_node -> data = data;
        new_node -> next = *head_ref;
 
        *head_ref = new_node;
}
 
void insert_after_a_given_node(struct Node* prev_node, int data){
        if (prev_node == NULL){
                printf("Previous Node cannot be NULL");
                return;
        }
 
        struct Node* new_node = (struct Node*)malloc(sizeof(struct Node));
        new_node->data = data;
        new_node->next = prev_node->next;
        prev_node->next = new_node;
}
 
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
 
void delete_a_node(struct Node** head_ref, int data){
	struct Node* current_node = *head_ref;
	struct Node* prev;
 
	//If head node is to be deleted
	if (current_node != NULL && current_node->data == data){
		*head_ref = current_node->next;
		free(current_node);
		return;
	}
 
	//Search of the key to be deleted and keep track of previous node
	while(current_node != NULL && current_node->data != data){
		prev = current_node;
		current_node = current_node->next;
	}
 
	if (current_node == NULL){
		return;
	}
 
	prev->next = current_node->next;
	free(current_node);
	return;
}
 
void printLinkedList(struct Node* head){
        while (head != NULL){
                printf("%d ", head -> data);
                head = head -> next;
        }
        printf("\n");
}
 
int main(void) {
 
        struct Node* head = NULL;
        insert_at_end(&head, 6);
        insert_at_beginning(&head, 2);
        insert_at_end(&head, 7);
        insert_after_a_given_node(head->next, 3);
 
        printLinkedList(head);
 
	printf("Deleting a Node\n");
	delete_a_node(&head, 3);

	printLinkedList(head);
 
        return 0;
}
 
