package Algorithms_FourthEdition.Part_I.I_Fundamentals.BagsQueueStacks.dataStructures.stack;

public class LinkedListStackImpl {

    private Node first = null;

    public boolean isEmpty(){
        return first == null;
    }

    public void push(String item){
        Node nextNode = first;
        first = new Node();
        first.item = item;
        first.next = nextNode;
    }

    public String pop(){
        String item = first.item;
        first = first.next;
        return item;
    }


    private class Node{
        String item;
        Node next;
    }
    
}
