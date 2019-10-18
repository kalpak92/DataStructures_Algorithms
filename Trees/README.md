# Binary Trees

A binary tree is made of nodes, where each node contains a "left" pointer, a "right" pointer, and a data element. The "root" pointer points to the topmost node in the tree. The left and right pointers recursively point to smaller "subtrees" on either side. A null pointer represents a binary tree with no elements -- the empty tree. The formal recursive definition is: a **binary tree** is either empty (represented by a null pointer), or is made of a single node, where the left and right pointers (recursive definition ahead) each point to a **binary tree**.

![a drawing of a little binary tree](http://cslibrary.stanford.edu/110/binarytree.gif)

A "**binary search tree**" (BST) or "ordered binary tree" is a type of binary tree where the nodes are arranged in order: for each node, all elements in its left subtree are less-or-equal to the node (<=), and all the elements in its right subtree are greater than the node (>). 

The tree shown above is a binary search tree -- the "root" node is a 5, and its left subtree nodes (1, 3, 4) are <= 5, and its right subtree nodes (6, 9) are > 5. Recursively, each of the subtrees must also obey the binary search tree constraint: in the (1, 3, 4) subtree, the 3 is the root, the 1 <= 3 and 4 > 3. Watch out for the exact wording in the problems -- a "binary search tree" is different from a "binary tree".

The nodes at the bottom edge of the tree have empty subtrees and are called "leaf" nodes (1, 4, 6) while the others are "internal" nodes (3, 5, 9).

### Binary Search Tree Niche

Basically, **binary search trees are fast at insert and lookup**. 

The next section presents the code for these two algorithms. On average, a binary search tree algorithm can locate a node in an N node tree in order ***lg(N) time (log base 2)***. Therefore, binary search trees are good for "dictionary" problems where the code inserts and looks up information indexed by some key. The lg(N) behavior is the average case -- it's possible for a particular tree to be much slower depending on its shape.

### Binary Tree Structure

```java
public class BinaryTree {
  // Root node pointer. Will be null for an empty tree.
  private Node root;


  /*
  --Node--
  The binary tree is built using this nested node class.
  Each node stores one data element, and has left and right
  sub-tree pointer which may be null.
  The node is a "dumb" nested class -- we just use it for
  storage; it does not have any methods.
  */
  private static class Node {
    Node left;
    Node right;
    int data;

    Node(int newData) {
        left = null;
        right = null;
        data = newData;
    }
  }

  /**
   Creates an empty binary tree -- a null root pointer.
  */
  public void BinaryTree() {
  	root = null;
  }


  /**
   Returns true if the given target is in the binary tree.
  Uses a recursive helper.
  */
  public boolean lookup(int data) {
  	return(lookup(root, data));
  }


  /**
   Recursive lookup  -- given a node, recur
  down searching for the given data.
  */
  private boolean lookup(Node node, int data) {
    if (node==null) {
        return(false);
    }

    if (data==node.data) {
        return(true);
    }
    else if (data<node.data) {
        return(lookup(node.left, data));
    }
    else {
        return(lookup(node.right, data));
    }
  }


  /**
   Inserts the given data into the binary tree.
  Uses a recursive helper.
  */
  public void insert(int data) {
  	root = insert(root, data);
  }


  /**
   Recursive insert -- given a node pointer, recur down and
  insert the given data into the tree. Returns the new
  node pointer (the standard way to communicate
  a changed pointer back to the caller).
  */
  private Node insert(Node node, int data) {
  if (node==null) {
      node = new Node(data);
  }
  else {
      if (data <= node.data) {
      node.left = insert(node.left, data);
      }
      else {
      node.right = insert(node.right, data);
      }
  }

  return(node); // in any case, return the new pointer to the caller
}
```

### OOP Style vs. Recursive Style

From the client point of view, the BinaryTree class demonstrates good OOP style -- it encapsulates the binary tree state, and the client sends messages like lookup() and insert() to operate on that state. 

Internally, the Node class and the recursive methods **do not** demonstrate OOP style. The recursive methods like insert(Node) and lookup (Node, int) basically look like recursive functions in any language. In particular, they do not operate against a "receiver" in any special way. Instead, the recursive methods operate on the arguments that are passed in which is the classical way to write recursion. My sense is that the OOP style and the recursive style do not be combined nicely for binary trees, so I have left them separate. Merging the two styles would be especially awkward for the "empty" tree (null) case, since you can't send a message to the null pointer. It's possible to get around that by having a special object to represent the null tree, but that seems like a distraction to me. I prefer to keep the recursive methods simple, and use different examples to teach OOP.

