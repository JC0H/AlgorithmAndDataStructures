package Algorithms_FourthEdition.Part_I.III_Searching.ll_Binary_Search_Trees;

/*
Combines the flexibility of insertion in linked lists with the efficiency of search in an ordered array.
A binary search tree (BST) is a binary tree where each node has a Comparable key (and an associated value)
and satisfies the restriction that the key in any node is larger than the keys in all nodes in that node's l
eft subtree and smaller than the keys in all nodes in that node's right subtree.
*/

import java.util.NoSuchElementException;

public class BST<Key extends Comparable<Key>, Value> {
    private Node root;  //root of BST
    /* We define a inner private class to define nodes in BST. Each node contains a key, a value, a left link,
       a right link, and a node count. The left link points to a BST for items with smaller keys, and the right
       link points to a BST for items with larger keys. The instance variable N gives the node count in the
       subtree rooted at the node.*/

    private class Node{
        private Key key;           // sorted by key
        private Value val;         // associated data
        private Node left, right;  // left and right subtrees
        private int size;          // number of nodes in subtree

        public Node(Key key, Value val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }

   /* Search. A recursive algorithm to search for a key in a BST follows immediately from the recursive structure:
     - If the tree is empty, we have a search miss;
     - If the search key is equal to the key at the root, we have a search hit.
     - Otherwise, we search (recursively) in the appropriate subtree.
     Get method takes a node (root of a subtree) as first argument and a key as second argument,
     starting with the root of the tree and the search key.*/
    public Value get(Key key){
        return get(root,key);
    }

    private Value get(Node node, Key key) {
        if (key == null) throw  new IllegalArgumentException("calls get() with a null key");
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if      (cmp < 0) return get(node.left, key);
        else if (cmp > 0) return get(node.right, key);
        else              return node.val;
    }

    /*
    Insert. Insert is not much more difficult to implement than search. Indeed, a search for a key not in the tree
    ends at a null link, and all that we need to do is replace that link with a new node containing the key.
    The recursive put() method accomplishes this task using logic similar to that we used for the recursive
    search: If the tree is empty, we return a new node containing the key and value; if the search key is less
    than the key at the root, we set the left link to the result of inserting the key into the left subtree;
    otherwise, we set the right link to the result of inserting the key into the right subtree.
    */
    public void put(Key key, Value value){
        if (key == null) throw new IllegalArgumentException("calls put() with a null key");
        if (value == null) {
            delete(key);
            return;
        }
        root = put(root, key, value);
    }

    private Node put(Node x,Key key, Value value){
        if (x == null) return new Node(key,value,1);
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left = put(x.left,key,value);
        else if (cmp > 0) x.right = put(x.right,key,value);
        else              x.val   = value;
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    /*
     * Removes the smallest key and associated value from the symbol table.
     */
    public void deleteMin() {
        if (isEmpty()) throw new NoSuchElementException("Symbol table underflow");
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    /*
     * Removes the largest key and associated value from the symbol table.
     */
    public void deleteMax() {
        if (isEmpty()) throw new NoSuchElementException("Symbol table underflow");
        root = deleteMax(root);

    }

    private Node deleteMax(Node x) {
        if (x.right == null) return x.left;
        x.right = deleteMax(x.right);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    /*
     * Removes the specified key and its associated value from this symbol table
     * (if the key is in this symbol table).
     */
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("calls delete() with a null key");
        root = delete(root, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) return null;

        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = delete(x.left,  key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else {
            if (x.right == null) return x.left;
            if (x.left  == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    /*
     * Returns the smallest key in the symbol table.
     */
    public Key min() {
        if (isEmpty()) throw new NoSuchElementException("calls min() with empty symbol table");
        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left == null) return x;
        else                return min(x.left);
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        else return x.size;
    }
}
