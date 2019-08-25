package Algorithms_FourthEdition.Part_I.I_Fundamentals.lll_Queue;

/*
A FIFO queue (or just a queue) is a collection that is based on the first in- first-out (FIFO) policy.
The policy of doing tasks in the same order that they arrive is one that we encounter frequently in everyday life:
from people waiting in line at a theater, to cars waiting in line at a toll booth, to tasks waiting to be serviced
by an application on your computer.
*/

import java.util.Iterator;

public class Queue <Item> implements Iterable<Item> {

    private Node<Item> first;  //beginind of the queue
    private Node<Item> last;   //endof the queue
    private int N;             //number of elements in the queue

    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    private static class Node<Item> {
        private Node next;
        private Item item;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public int size(){
        return N;
    }

    //add item to the end of the queue
    public void enqueue(Item text){
        Node<Item> oldLast = last;
        last = new Node<>();
        last.item = text;
        last.next = null;
        if (isEmpty()) first = last;
        else           oldLast.next = last;
        N++;
    }

    //Remove item from the beginning of the list
    public Item dequeue(){
        Item item =first.item;
        first = first.next;
        if (isEmpty()) last = null;
        N--;
        return item;
    }
}
