# DataStructures_Algorithms
## Runtime Analysis

#### Big O Notation

- *Big O Notation* is used to describe the upper bound of a particular algorithm. Big O is used to describe worst case scenarios

[![Alt text](https://github.com/kdn251/interviews/raw/master/images/bigO.png?raw=true)](https://github.com/kdn251/interviews/blob/master/images/bigO.png?raw=true)

#### Little O Notation

- *Little O Notation* is also used to describe an upper bound of a particular algorithm; however, Little O provides a bound that is not asymptotically tight

#### Big Ω Omega Notation

- *Big Omega Notation* is used to provide an asymptotic lower bound on a particular algorithm

[![Alt text](https://github.com/kdn251/interviews/raw/master/images/bigOmega.png?raw=true)](https://github.com/kdn251/interviews/blob/master/images/bigOmega.png?raw=true)

#### Little ω Omega Notation

- *Little Omega Notation* is used to provide a lower bound on a particular algorithm that is not asymptotically tight

#### Theta Θ Notation

- *Theta Notation* is used to provide a bound on a particular algorithm such that it can be "sandwiched" between two constants (one for an upper limit and one for a lower limit) for sufficiently large values

[![Alt text](https://github.com/kdn251/interviews/raw/master/images/theta.png?raw=true)](https://github.com/kdn251/interviews/blob/master/images/theta.png?raw=true)





## Data Structures

### Linked List

- A *Linked List* is a linear collection of data elements, called nodes, each pointing to the next node by means of a pointer. It is a data structure consisting of a group of nodes which together represent a sequence.
- **Singly-linked list**: linked list in which each node points to the next node and the last node points to null
- **Doubly-linked list**: linked list in which each node has two pointers, p and n, such that p points to the previous node and n points to the next node; the last node's n pointer points to null
- **Circular-linked list**: linked list in which each node points to the next node and the last node points back to the first node
- Time Complexity:
  - Access: `O(n)`
  - Search: `O(n)`
  - Insert: `O(1)`
  - Remove: `O(1)`

### Stack

- A *Stack* is a collection of elements, with two principle operations: *push*, which adds to the collection, and *pop*, which removes the most recently added element
- **Last in, first out data structure (LIFO)**: the most recently added object is the first to be removed
- Time Complexity:
  - Access: `O(n)`
  - Search: `O(n)`
  - Insert: `O(1)`
  - Remove: `O(1)`

### Queue

- A *Queue* is a collection of elements, supporting two principle operations: *enqueue*, which inserts an element into the queue, and *dequeue*, which removes an element from the queue
- **First in, first out data structure (FIFO)**: the oldest added object is the first to be removed
- Time Complexity:
  - Access: `O(n)`
  - Search: `O(n)`
  - Insert: `O(1)`
  - Remove: `O(1)`