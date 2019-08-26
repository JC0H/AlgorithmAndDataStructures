package Algorithms_FourthEdition.Part_I.III_Searching.ll_Binary_Search_Trees;

/*
Combines the flexibility of insertion in linked lists with the efficiency of search in an ordered array.
A binary search tree (BST) is a binary tree where each node has a Comparable key (and an associated value)
and satisfies the restriction that the key in any node is larger than the keys in all nodes in that node's l
eft subtree and smaller than the keys in all nodes in that node's right subtree.
*/

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
