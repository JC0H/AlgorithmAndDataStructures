package Algorithms_FourthEdition.Part_I.I_Fundamentals.BagsQueueStacks;

public class BRT<Key extends Comparable<Key>, Value> {

    private static final boolean RED = true;
    private static final boolean BLACK = true;
    private Node root;

    private class Node{
        Key key;
        Value value;
        Node left,right;
        int N;
        boolean color;

        public Node(Key key, Value value, boolean color) {
            this.key = key;
            this.value = value;
            this.color = color;
        }

        public Node(Key key, Value value, int n, boolean color) {
            this.key = key;
            this.value = value;
            N = n;
            this.color = color;
        }
    }

    public boolean isRed(Node x){
        if (x == null) return false;
        return x.color == RED;
    }

    private Node rotateLeft(Node h){
        assert isRed(h.right);
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private Node rotateRight(Node h){
        assert isRed(h.left);
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private Value get(Key key){
        Node x = root;
        while(x != null){
            int cmp = key.compareTo(x.key);
            if      (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else              return x.value;
        }
        return null;
    }

    private void flipColors(Node n){
        assert !isRed(n);
        assert  isRed(n.left);
        assert isRed(n.right);
        n.color = RED;
        n.left.color = BLACK;
        n.right.color = BLACK;
    }

    /*
    *Right child red, left child black : rotate left
    *Left child, left-left child grandchild red : rotate rotate right
    *Both children red : flipColors
    */
    private Node put(Node h, Key key, Value value){
        if (h ==  null) return new Node(key,value,RED);
        int cmp =  key.compareTo(h.key);
        if      (cmp < 0) h.left = put(h.left,key,value);
        else if (cmp > 0) h.right = put(h.right,key,value);
        else              h.value = value;

        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left))  h = rotateRight(h);
        if (isRed(h.right)  && isRed(h.right))   flipColors(h);

        return h;
    }

}
