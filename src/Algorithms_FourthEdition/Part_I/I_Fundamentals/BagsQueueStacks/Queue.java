package Algorithms_FourthEdition.Part_I.I_Fundamentals.BagsQueueStacks;

public class Queue <Item>{

    private Node first;
    private Node last;
    private int N;

    private class Node{
        Node next;
        Item item;
    }

    public boolean isEmpty(){
        return N==0;
    }

    public int size(){
        return N;
    }

    //add item to the end of the queue
    public void enqueue(Item text){
        Node oldLast = last;
        last = new Node();
        last.item = text;
        last.next = null;
        if(isEmpty()) first = last;
        else oldLast.next = last;
        N++;
    }

    //Remove item from the beginning of the list
    public Item dequeue(){
        Item item = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        N--;
        return item;
    }
}
