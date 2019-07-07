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

        boolean res = stack.find(stack,"Friend");
        System.out.println(res);
    }
}
