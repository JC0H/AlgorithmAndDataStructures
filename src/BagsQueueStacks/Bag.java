package BagsQueueStacks;

public class Bag<Item> {

    private int N;
    private Node first;

    private class Node{
        Item item;
        Node next;
    }

    public void add(Item item){
        Node oldFirst = first; // kopy of the first node.
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    public int size(){
        return N;
    }
}
