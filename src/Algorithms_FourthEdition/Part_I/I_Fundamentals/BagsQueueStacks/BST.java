package Algorithms_FourthEdition.Part_I.I_Fundamentals.BagsQueueStacks;

public class BST<Key extends Comparable<Key>, Value> {

    private Node root;

    private class Node{
        private Key key;
        private Value value;
        private Node left,right;
        private int count;
        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }

        public Node(Key key, Value value, int count) {
            this.key = key;
            this.value = value;
            this.count = count;
        }
    }

    public void put (Key key, Value value){
        root = put(root,key,value);
    }

    private Node put(Node root, Key key, Value value) {
        if (root == null)   return new Node(key,value,1);
        int cmp = key.compareTo(root.key);
        if     (cmp < 0) root.left = put(root.left,key,value);
        else if(cmp > 0) root.right = put(root.right,key,value);
        else             root.value = value;
        root.count = 1 + size(root.left) + size(root.right);
        return root;
    }

    public Key floor(Key key){
        Node x = floor(root,key);
        if (x == null) return null;
        return x.key;
    }

    private Node floor(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp <  0) return floor(x.left,key);

        Node t = floor(x.right,key);
        if (t != null) return t;
        else           return x;
    }

    public int rank(Key key){
        return rank(root,key);
    }

    private int rank(Node x, Key key) {
        if (x == null) return 0;
        int cmp  =  key.compareTo(x.key);
        if      (cmp < 0) return rank(x.left,key);
        else if (cmp > 0) return 1 + size(x.left) + rank(x.right,key);
        else              return size(x.left);
    }

    public int size(){
        return size(root);
    }

    private int size(Node root) {
        if (root == null) return 0;
        return root.count;
    }

    public Value get(Key key){
        Node x = root;
        while (x != null){
            int cmp = key.compareTo(x.key);
            if      (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else              return x.value;
        }

        return  null;
    }

    public void delete(Key key){
        delete(root,key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if     (cmp < 0) x.left = delete(x.left,key);
        else if(cmp > 0) x.right = delete(x.right,key);
        else{
            if (x.left ==  null) return x.right;
            if (x.right == null) return x.left;

            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }

    public Key min()
    {
        return min(root).key;
    }
    private Node min(Node x)
    {
        if (x.left == null) return x;
        return min(x.left);
    }

    public void deleteMin(){
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }
/*
    public Iterable<Key> keys(){
        Queue<Key> q = new Queue<>();
        inorder(root,q);
        return q;
    }

    //implement enqueue method
    private void inorder(Node x, Queue<Key> q) {
        if (x == null) return;
        inorder(x.left,q);
        q.enquequ(x.key);
        inorder(x.right,q);
    }
 */
}
