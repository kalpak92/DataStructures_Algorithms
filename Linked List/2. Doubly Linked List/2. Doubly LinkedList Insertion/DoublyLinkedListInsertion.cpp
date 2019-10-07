#include <iostream>
using namespace std;

class DLLNode
{
    public:
        int data;
        DLLNode* nextElement;
        DLLNode* prevElement;

        DLLNode()
        {
            nextElement = nullptr;
            prevElement = nullptr;
        }
};

class DoublyLinkedList
{
    private:
        DLLNode* head;
    
    public:
        DoublyLinkedList()
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

        void printDLL()
        {
            if (isEmpty())
            {
                cout << "Doubly DoublyLinkedList is empty." << endl;
            }

            DLLNode* temp = head;
            while (temp != nullptr)
            {
                cout << temp->data << "->";
                temp = temp->nextElement;
            }
            cout << "null " << endl;
        }

        void insertAtHead(int value)
        {
            DLLNode* newNode = new DLLNode();
            newNode->data = value;

            newNode->nextElement = head;

            if (head != nullptr)
                head->prevElement = newNode;
            
            head = newNode;
            cout << value << " inserted." << endl;

        }

        void insertAtTail(int value)
        {
            DLLNode* newNode = new DLLNode();
            newNode->data = value;

            DLLNode* temp = head;

            while (temp->nextElement != nullptr)
                temp = temp->nextElement;

            temp->nextElement = newNode;
            newNode->prevElement = temp;

            cout << value << " inserted." << endl;
        }
};

int main()
{
    DoublyLinkedList list; // DoublyLinkedList created

    for (int i = 0; i < 5; i++)
    {
        list.insertAtHead(i+1);
        list.printDLL();
    }

    for (int i = 30; i > 25; i--)
    {
        list.insertAtTail(i);
        list.printDLL();
    }

    return 0;
}