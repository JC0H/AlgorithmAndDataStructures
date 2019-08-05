package Algorithms_FourthEdition.Part_I.I_Fundamentals.BagsQueueStacks;
/*
* Write an iterable Stack client that has a static method copy() that takes a stack
of strings as argument and returns a copy of the stack. Note : This ability is a prime
example of the value of having an iterator, because it allows development of such functionality
without changing the basic API.
*
* */


import Algorithms_FourthEdition.Part_I.I_Fundamentals.II_Stack.Stack;

import java.util.Iterator;

public class _12_StackCopy {

    private static String copyStack = new String();

    public static String copy(Stack<String> stack){
        Iterator iterator = stack.iterator();

        while (iterator.hasNext()){
            copyStack = copyStack + iterator.next();
        }

        return copyStack;
    }

}
