package BagsQueueStacks;

import java.util.Iterator;

public class Stack <Item> implements Iterable<Item>{

    private Node first;
    private int N;


    public class Node{
        Node node;
        Item item;
    }

    public int size() {
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

    /*
     * Write a method delete() that takes an int argument k and deletes
     * the kth element in a linked list, if it exists.
     */
    public void delete(int k){
        if(size() <= k ) {
            System.out.println("There is no " + k  +" element in stack");
        }

        Node n = first;
        for (int i = 0; i < k; i++){
            n = n.node;
        }

        n.node = n.node.node;
        System.out.println();
    }

    /*Write a method find() that takes a linked list and a string key as arguments
      and returns true if some node in the list has key as its item field, false otherwise.*/
    public boolean find(Stack<String> stack, String key){
         Node n = first;

         for (int i = 0; i < stack.size(); i ++){
            n = n.node;
            if (n.item.toString() == key)
                return true;
         }
         return false;
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

        public Item next() {
            Item item = current.item;
            current = current.node;
            return item;
        }

    }
}
