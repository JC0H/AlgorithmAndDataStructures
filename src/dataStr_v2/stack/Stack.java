package dataStr_v2.stack;

public class Stack <Item>{

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
}
