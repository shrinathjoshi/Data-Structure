package com.util.stack;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/**
 * @author Shrinath Joshi
 * MyStack is an implementation of Stack
 * 
 * 
 * Stack is a data structure which uses FIFO ordering
 * It uses the following operations
 *      1. push(item ) - add an item to the stack
 *      2. pop() - remove an element from the stack
 *      3. peek() - return the top of stack
 *      4. isEmpty() - returns true if the stack is empty
 *      5. printStack() - prints the elements of the stack 
 * 
 */
public class MyStack<T> {

    private StackNode<T> top;

    class StackNode<T>{
        private T data;
        private StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

    }

    public void push(T data){
        StackNode<T> element = new StackNode<>(data);
        element.next=top;
        top=element;
    }

    public T pop(){
        if(top == null) throw new EmptyStackException();
        T element= (T) top.getData();
        top = top.next;
        return element;
    }

    public  T peek() {
        if(top == null) throw new EmptyStackException();
        T element= (T) top.getData();
        return element;
    }

    public boolean isEmpty(){
        return (top == null)?true:false;
    }

    public List<T> printStack(){
        if(top == null) throw new EmptyStackException();
        StackNode<T> temp = top;
        ArrayList<T> result=new ArrayList<>();
        while (temp != null)
        {
            result.add((T) temp.data);
            temp=temp.next;
        }
        return result;
    }

}