import java.util.List;

import com.util.stack.MyStack;

/**
 * @author Shrinath Joshi
 * MyStackDemo
 */

public class MyStackDemo {

    public static void main(String[] args) {
        
        MyStack<Integer> myStack = new MyStack<>();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);

        displayStackContents(myStack);
       
        System.out.println(myStack.pop());
        System.out.println(myStack.peek());
        System.out.println(myStack.pop());
        
    }

    private static void displayStackContents(MyStack<Integer> myStack) {

        List<Integer> result =  myStack.printStack();
        if(result.size() != 0 )
            System.out.print("Stack :- ");
            for (Integer s :result) {
                System.out.print(s+ " ");
            }
        System.out.println();


    }
}


/*
OUTPUT:-
Stack :- 3 2 1 
3
2
2

*/