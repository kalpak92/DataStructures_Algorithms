class Node:
    def __init__(self, data):
        self.data = data
        self.prev = None
        self.next = None

    def get_data(self):
        return self.data


class DoublyLinkedList:
    def __init__(self):
        self.head = None
    
    def isEmpty(self):
        if self.head == None:
            return True
        else:
            return False

def main():
    dll = DoublyLinkedList();
    print(dll.isEmpty())

if __name__ == "__main__":
    main()