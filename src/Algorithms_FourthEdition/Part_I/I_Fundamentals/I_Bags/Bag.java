package Algorithms_FourthEdition.Part_I.I_Fundamentals.I_Bags;

import java.util.Iterator;
import java.util.NoSuchElementException;

/*
A bag is a collection where removing items is not supported — its purpose is to
provide clients with the ability to collect items and then to iterate through the collected
items (the client can also test if a bag is empty and find its number of items). The order
of iteration is unspecified and should be immaterial to the client.
*/

public class Bag<Item> implements Iterable<Item> {

    private int N;                //number of elements in a bag
    private Node<Item> first;     //beginning of bag

    public Bag() {                //Initializes an empty bag.
        first = null;
        N = 0;
    }

    private static class Node<Item> {  // helper linked list class
        private Item item;
        private Node<Item> next;
    }

    public void add(Item item) {
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    public int size(){
        return N;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public Iterator<Item> iterator()  {
        return new ListIterator(first);
    }

    private class ListIterator implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  } // because Bag cannot remove

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
