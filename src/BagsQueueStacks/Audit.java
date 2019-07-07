package BagsQueueStacks;

import java.util.Iterator;

public class Audit {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("Hello");
        stack.push("My");
        stack.push("Darlind");
        stack.push("Hello");
        stack.push("My");
        stack.push("Friend");

        _12_StackCopy copy = new _12_StackCopy();
        String list  = copy.copy(stack);
        System.out.println(list);
    }
}
