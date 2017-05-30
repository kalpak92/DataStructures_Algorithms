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
 
void sort_linked_list_of_012(struct Node* head_ref){
	int count[3] = {0, 0, 0};
	struct Node* ptr = head_ref;
 
	while (ptr != NULL){
		count[ptr->data] += 1;
		ptr = ptr->next;
	}
 
	int i = 0;
	ptr = head_ref;
 
	while(ptr != NULL){
		if (count[i]==0){
			++i;
		}
		else {
			ptr->data = i;
			--count[i];
			ptr = ptr->next;
		}
	}
 
}
 
int main(void) {
	struct Node* head = NULL;
    insert_at_end(&head, 0);
    insert_at_end(&head, 1);
    insert_at_end(&head, 2);
    insert_at_end(&head, 1);
    insert_at_end(&head, 0);
    insert_at_end(&head, 2);
    insert_at_end(&head, 2);
    insert_at_end(&head, 0);
    insert_at_end(&head, 1);
    insert_at_end(&head, 0);
 
    printLinkedList(head);
 
 	sort_linked_list_of_012(head);
 	printLinkedList(head);
 
	return 0;
}
