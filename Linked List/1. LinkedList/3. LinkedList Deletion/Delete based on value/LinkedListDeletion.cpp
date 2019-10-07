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

        void deleteANode(int value) 
        {
            if (isEmpty())
            {
            return;
            }
            Node* currentNode = head;
            Node* prev;

            if (currentNode != NULL and currentNode->data == value)
            {
                head = currentNode->nextElement;
                cout << "Deleted." << endl;
                free(currentNode);
                return;
            }

            while(currentNode != NULL and currentNode->data != value)
            {
                prev = currentNode;
                currentNode = currentNode->nextElement;
            }
            if (currentNode == NULL)
            {
                cout << value << " does not exist." << endl;
                return;
            }
                            
            prev->nextElement = currentNode->nextElement;
            cout << "Deleted." << endl;
            free(currentNode);
            return;

        }  
};

int main()
{
    LinkedList list; // LinkedList created

    for (int i = 0; i < 10; i++)
    {
        list.insertAtTail(i);
        list.printList();
    }
    cout << "Delete Node with value 5." << endl;
    list.deleteANode(5);
    list.printList();

    return 0;
}