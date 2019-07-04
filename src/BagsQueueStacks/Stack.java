package BagsQueueStacks;

import java.util.Iterator;

public class Stack <Item> implements Iterable<Item>{

    private Node first;
    private int N;


    private class Node{
        Node node;
        Item item;
    }

    public int size(){
        return N;
    }

    public boolean isEmpty(){
        return N==0;
    }

    //add item to top of stack
    public void push(Item text){
        Node newNode = first;
        first = new Node();
        first.item = text;
        first.node = newNode;
        N++;
    }

    //Remove item from top of stack
    public Item pop(){
        Item item = first.item;
        first = first.node;
        N--;
        return item;
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < size(); i++) {
            result = result + pop();
        }
        return result;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {

        private Node current = first;
        public boolean hasNext() {
            return current != null;
        }
        public Item next()
        {
            Item item = current.item;
            current = current.node;
            return item;
        }
    }
}
