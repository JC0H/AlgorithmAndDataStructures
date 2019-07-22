package BagsQueueStacks;

public class SequentialSearchST<Key,Value> {
    private int n;   // number of key-values pairs
    private Node first;

    private class Node{
        private Key key;
        private Value value;
        private Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public int size(){
        return n;
    }

    public boolean isEmpty(){
        return n == 0;
    }

    public boolean contains (Key key){
        if (key == null) throw new IllegalArgumentException("Illegal argument. Value contains null");
        return get(key) != null;
    }

    public Value get(Key key){
        if (key == null) throw new IllegalArgumentException("Illegal argument. Value contains null");
        for (Node i = first; i != null; i = i.next){
            if (key.equals(i.key))
                return i.value;
        }
        return null;
    }

    public void put(Key key, Value value){
        if (key == null) throw new IllegalArgumentException("Illegal argument. Value contains null");
        if (value == null){
            delete(key);
            return;
        }

        for (Node x = first; x != null; x = x.next){
            if (key.equals(x.key)) {
                value = x.value;
                return;
            }
        }
        first = new Node(key,value,first);
    }

    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");
        first = delete(first, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) return null;
        if (key.equals(x.key)) {
            n--;
            return x.next;
        }
        x.next = delete(x.next, key);
        return x;
    }
}
