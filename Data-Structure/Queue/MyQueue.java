package com.util.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author Shrinath Joshi
 * 
 * MyQueue.java is a linkedList implementation of Queue
 * 
 * Queue is a data structure which uses LIFO ordering
 * It uses the following operations
 *      1. add(item ) - add an item to the queue
 *      2. remove() - remove an element from the queue
 *      3. peek() - return the top of queue
 *      4. isEmpty() - returns true if the queue is empty
 *      5. printQueue() - prints the elements of the queue 
 */
public class MyQueue<T>{

    private QueueNode<T> first ;
    private QueueNode<T> last ;

    class QueueNode<T>{
        private T data;
        private QueueNode<T> next;

        public QueueNode(T data) {
            this.data = data;
        }

        public T getData(){
            return data;
        }
    }

    public void add (T data){
        QueueNode<T> element = new QueueNode<>(data);
        
        if(last != null)
            last.next=element;
        
        last = element;
        if(first == null)
            first=element;
    }

    public T remove(){
        if(first == null) throw new  NoSuchElementException();

        QueueNode<T> element = first;
        first = first.next;
        if(first == null)
            last=null;

        return element.getData();
    }

    public T peek(){
        if(first ==  null) throw new NoSuchElementException();
        return first.getData();
    }

    public boolean isEmpty(){
        return first==last;
    }

    public List<T> printQueue(){
        if(first == null) throw new NoSuchElementException();
        QueueNode<T> temp = first;
        ArrayList<T> result=new ArrayList<>();
        while (temp != null)
        {
            result.add(temp.data);
            temp=temp.next;
        }
        return result;
    }

}