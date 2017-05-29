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

void detect_a_loop(struct Node* head_ref){
	struct Node* slow_ptr = head_ref;
	struct Node* fast_ptr = head_ref;
	
	while(slow_ptr && fast_ptr && fast_ptr->next){
		slow_ptr = slow_ptr->next;
		fast_ptr = fast_ptr->next->next;
		
		if (slow_ptr == fast_ptr){
			printf("Loop Found");
			return;
		}
	}
	
}

int main(void) {
	struct Node* head = NULL;
    insert_at_end(&head, 1);
    insert_at_end(&head, 2);
    insert_at_end(&head, 3);
    insert_at_end(&head, 4);
    insert_at_end(&head, 5);
    
    head->next->next->next->next = head->next->next;
    
    detect_a_loop(head);
    
	return 0;
}