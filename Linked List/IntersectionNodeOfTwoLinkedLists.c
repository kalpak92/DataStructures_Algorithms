#include <stdio.h>
#include <stdlib.h>

struct Node{
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


int get_count(struct Node* head){
	struct Node* current = head;
	int count = 0;
	
	while (current != NULL){
		count ++;
		current = current->next;
	}
	//printf("%d\n", count);
	return count;
}

struct Node* get_intersection_node(int diff, struct Node* head1, struct Node* head2){
	struct Node* current1 = head1;
	struct Node* current2 = head2;
	
	for (int i = 0; i < diff; i++){
		if (current1 == NULL){
			return NULL;
		}
		current1 = current1->next;
	}
	
	while (current1 != NULL && current2 != NULL){
		if (current1==current2)
			return current1;
		current1 = current1->next;
		current2 = current2->next;
	}
	
	return NULL;
}

struct Node* intersection_node_of_linked_lists(struct Node* head1, struct Node* head2){
	int c1 = get_count(head1);
	int c2 = get_count(head2);
	int d;
	
	if (c1 > c2){
		d = c1 - c2;
		return get_intersection_node(d, head1, head2);
	}
	else {
		d = c2 - c1;
		return get_intersection_node(d, head2, head1);
	}
}

void printLinkedList(struct Node* head){
	while (head != NULL){
		printf("%d ", head -> data);
		head = head -> next;
	}
	printf("\n");
}


int main(void) {
	struct Node* head1 = NULL;
    insert_at_end(&head1, 1);
    insert_at_end(&head1, 2);
    insert_at_end(&head1, 3);
    insert_at_end(&head1, 4);
    insert_at_end(&head1, 5);
    
    printLinkedList(head1);
    
    struct Node* head2 = NULL;
    insert_at_end(&head2, 8);
    insert_at_end(&head2, 9);
    head2->next->next = head1->next->next->next;
    
    printLinkedList(head2);
    
    struct Node* intersection_node = intersection_node_of_linked_lists(head1, head2);
    printf("The Intersection node is: %d", intersection_node->data);
    
	return 0;
}
