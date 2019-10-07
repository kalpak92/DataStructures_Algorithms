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
};

int main()
{
    DoublyLinkedList list;
    cout << list.isEmpty() << endl;
}