#include <iostream>
using namespace std;

class Node 
{
    public:
        int data;
        Node* nextElement;

        Node()
        {
            nextElement = nullptr;
        }
};

class LinkedList
{
    private:
        Node* head;
    
    public:
        LinkedList()
        {
            head = nullptr;
        }

        bool isEmpty()
        {
            if (head == nullptr)
                return true;
            else
            {
                return false;
            }
        }

        // Print the LinkedList
        bool printList()
        {
            if (isEmpty())
            {
                cout << "List is Empty" << endl;
                return false;
            }

            Node* temp = head;
            cout << "List: ";

            while (temp != nullptr)
            {
                cout << temp->data << "->" ;
                temp = temp->nextElement;
            }
            cout << "null" << endl;
            return true;
        }

        // insert a new node as the first element of the list
        void insertAtHead(int value)
        {
            Node* newNode = new Node();
            newNode->data = value;
            newNode->nextElement = head;
            
            head = newNode;
            cout << value << " Inserted." << endl;
        }

        void insertAtTail(int value)
        {
            Node* newNode = new Node();
            newNode->data = value;

            if (isEmpty())
            {
                head = newNode;
                cout << "Inserted. " << endl;
                return;
            }

            Node* temp = head;
            while(temp->nextElement != nullptr)
            {
                temp = temp->nextElement;
            }
            temp->nextElement = newNode;
            cout << "Inserted." << endl;
        }

        void revereLinkedList()
        {
            if (head == NULL)
            {
                cout << "Empty Linked List. Cannot reverse." << endl;
            }

            Node* prev = NULL;
            Node* current = head;
            Node* next = NULL;

            while(current != NULL)
            {
                next = current->nextElement;
                current->nextElement = prev;
                prev = current;
                current = next;
            }
            head = prev;
        }
};

int main()
{
    LinkedList list; // LinkedList created

    for (int i = 0; i < 10; i++)
    {
        list.insertAtHead(i+1);
        //list.printList();
    }

    list.printList();

    cout << "Reverse LinkedList: " << endl;
    list.revereLinkedList();
    list.printList();
    
    return 0;
}