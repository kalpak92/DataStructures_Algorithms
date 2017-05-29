#include <stdio.h>
#include <stdlib.h>
 
struct Node{
	int data;
	struct Node *next;
};
 
void printLinkedList(struct Node* head){
	while (head != NULL){
		printf("%d ", head -> data);
		head = head -> next;
	}
	printf("\n");
}
 
int main(void) {
 
	struct Node* head = NULL;
	struct Node* second = NULL;
	struct Node* third = NULL;
 
	head = (struct Node*)malloc(sizeof(struct Node));
	second = (struct Node*)malloc(sizeof(struct Node));
	third = (struct Node*)malloc(sizeof(struct Node));
 
	head -> data = 1;
	head -> next = second;
 
	second -> data = 2;
	second -> next = third;
 
	third -> data = 3;
	third -> next = NULL;
 
	printLinkedList(head);
 
	return 0;
}