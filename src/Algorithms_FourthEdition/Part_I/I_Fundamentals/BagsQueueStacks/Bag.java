package Algorithms_FourthEdition.Part_I.I_Fundamentals.BagsQueueStacks;

import java.util.Iterator;

public class Bag<Item> implements Iterable<Integer> {

    private int N;
    private Node first;

    @Override
    public Iterator<Integer> iterator() {
        return null;
    }

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
