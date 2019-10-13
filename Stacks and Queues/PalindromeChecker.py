__author__ = 'Kalpak Seal'

class Deque:
    def __init__(self):
        self.deque = []

    def isEmpty(self):
        return self.deque == []

    def add_front(self, data):
        self.deque.insert(0, data)

    def add_rear(self, data):
        self.deque.append(data)

    def remove_front(self):
        return self.deque.pop(0)

    def remove_rear(self):
        return self.deque.pop()

    def size(self):
        return len(self.deque)

    def print(self):
        for i in self.deque:
            print (i, end=' ')
        print ()


def palindrome_checker(data):
    d = Deque()
    for ch in data:
        d.add_rear(ch)

    is_palindrome = True

    while d.size() > 1 and is_palindrome == True:
        first = d.remove_front()
        last = d.remove_rear()

        if first != last:
            is_palindrome = False

    return is_palindrome

if __name__ == '__main__':
    data = input('Enter a string to check for palindrome: ')

    print("Checking if the string is Palindrome: ", palindrome_checker(data))