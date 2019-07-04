package BagsQueueStacks;

public class Queue <Item>{

    private Node first;
    private Node last;
    private int N;

    private class Node{
        Node next;
        Item item;
    }

    private boolean isEmpty(){
        return N==0;
    }

    private int size(){
        return N;
    }

    //add item to the end of the queue
    private void enqueue(Item text){
        Node oldLast = last;
        last = new Node();
        last.item = text;
        last.next = null;
        if(isEmpty()) first = last;
        else oldLast.next = last;
        N++;
    }

    //Remove item from the beginning of the list
    private Item dequeue(){
        Item item = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        N--;
        return item;
    }
}
