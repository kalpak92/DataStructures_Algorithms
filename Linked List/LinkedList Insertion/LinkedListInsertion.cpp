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

        void insertAtNthNode(int value, int k)
        {
            if (isEmpty())
            {
                cout << "List is Empty." << endl;
                return;
            }
            int count = 1;
            Node* temp = head;

            while (temp->nextElement != nullptr && count < (k-1))
            {
                temp = temp->nextElement;
                count++;
            }

            if (temp != nullptr && count == (k-1))
            {
                Node* newNode = new Node();
                newNode->data = value;
                newNode->nextElement = temp->nextElement;
                temp->nextElement = newNode;
                cout << "Inserted" << endl;
            }
            else
            {
                cout << "Position larger than the size of the linked list." << endl;
            }
        }
};

int main()
{
    LinkedList list; // LinkedList created

    for (int i = 0; i < 10; i++)
    {
        list.insertAtHead(i+1);
        list.printList();
    }

    int pos = 5;
    cout << "Inserting Node at postion " << pos << endl;
    list.insertAtNthNode(50, pos);
    list.printList();

    for (int i = 30; i > 20; i--)
    {
        list.insertAtTail(i);
        list.printList();
    }


    return 0;
}