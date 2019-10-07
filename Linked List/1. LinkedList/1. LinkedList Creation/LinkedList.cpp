#include <iostream>

using namespace std;

class Node{
    public:
        int data;               // Data to store (could be int,string,object etc)
        Node* nextElement;      // Pointer to next Element

        // Constructor to initialize nextElement of newly created node
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
};

int main()
{
    LinkedList list; // LinkedList created
    cout << list.isEmpty() << endl;
}