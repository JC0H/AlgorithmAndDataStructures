package BagsQueueStacks;

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

}
