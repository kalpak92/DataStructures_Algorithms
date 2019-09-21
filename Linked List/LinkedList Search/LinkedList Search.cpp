#include <iostream>
using namespace std;

class Node
{
public:
    int data;
    Node* nextElement;
    Node(/* args */)
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

        // search if element exists in the list
        bool search(int value)
        {
            Node* temp = head;
            while (temp != nullptr)
            {
                if (temp->data == value)
                {
                    return true;
                }
                temp = temp->nextElement;
            }
            delete temp;
            return false;

        }
};

int main()
{
    LinkedList list;
    srand(time(NULL));

    int num = 0;
    for (int i = 1; i < 10; i++)
    {
        num = rand() % 10 + 1;
        list.insertAtHead(num);
        list.printList();
    }

    bool exist = false;   // exist it true only if element exists
    for(int j = 0; j < 5; j++) {
        num = rand() % 10 + 1; 
        exist = list.search(num);   // Calling search function
        if(exist) {     // only true if element exists
            cout << num << " exists!" << endl;
        }
        else {
            cout << num << " does not exist!" << endl;
        }
    }
}