package Algorithms_FourthEdition.Part_I.I_Fundamentals.II_Stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

/*A pushdown stack (or just a stack) is a collection that is based on the last-in-first-out (LIFO) policy.
For example, many people organize their email as a stack— they push messages on the top when they are received
and pop them from the top when they read them, with most recently received first (last in, first out).
The LIFO policy offered by a stack provides just the behavior that you expect. When a client iterates through
the items in a stack with the foreach construct, the items are processed in the reverse of the order in
which they were added.
*/

public class Stack <Item> implements Iterable<Item>{

    private Node<Item> first;
    private int N;

    public class Node<Item>{
        private Node node;
        private Item item;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty(){
        return N==0;
    }

    //add item to top of stack
    public void push(Item text){
        Node<Item> newNode = first;
        first = new Node();
        first.item = text;
        first.node = newNode;
        N++;
    }

    //Remove item from top of stack
    /*This operation is even easier: simply assign to first the value first.next. Normally, you would retrieve the value of
      the item (by assigning it to some variable of type Item) before doing this assignment, because once you change
      the value of first, you may not have any access to the node to which it was referring.*/
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

    /*Write a method removeAfter() that takes a linked-list Node as argument and
      removes the node following the given one (and does nothing if the argument or the next
      field in the argument node is null).*/
    public void removeAfter( Node node){
        node = first;
        if (node == null || node.node == null)
            return;
        else
           node.node = node.node.node;
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < size(); i++) {
            result = result + pop();
        }
        return result;
    }

    public Iterator<Item> iterator() {
        return new ListIterator(first);
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.node;
            return item;
        }
    }
}
