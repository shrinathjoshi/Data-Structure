package com.util.queue;

/**
 * @author Shrinath Joshi
 * 
 * CircularQueue.java is a Array implementation of Queue
 * 
 * Queue is a data structure which uses LIFO ordering
 * It uses the following operations
 *      1. add(item ) - add an item to the queue
 *      2. remove() - remove an element from the queue
 *      3. peek() - return the top of queue
 *      4. isEmpty() - returns true if the queue is empty
 *      5. display() - prints the elements of the queue 
 */
public class CircularQueue {
    private int MAX = 10;
    private int front;
    private int rear;
    private int queue[];
    private int size;

    public CircularQueue() {
        queue = new int[MAX];
        front = -1;
        size = 0;
        rear = -1;
    }

    public void add(int data) {
        if ((rear == front - 1) || (front == 0 && rear == MAX - 1)) {
            System.out.println("Queue Overflow");
            return;
        }
        if (rear == -1)
            front = rear = 0;
        else if (rear == MAX - 1)
            rear = 0;
        else
            rear++;
        queue[rear] = data;
    }

    public int remove() {
        if (front == -1) {
            System.out.println("Queue Underflow");
            return -1;
        }

        int value = queue[front];
        if (front == rear)
            front = rear = -1;
        else if (front == MAX - 1)
            front = 0;
        else
            front++;
        return value;
    }

    public int peek() {
        if (front == -1) {
            System.out.println("Queue Underflow");
            return -1;
        }

        int value = queue[front];
        return value;
    }

    public boolean isEmpty() {
        return (front == -1);
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue Empty");
            return;
        }
        if (front > rear) {
            for (int i = front; i < MAX; i++)
                System.out.print(queue[i] + " ");

            for (int i = 0; i <= rear; i++)
                System.out.print(queue[i] + " ");
        } else {
            for (int i = front; i <= rear; i++)
                System.out.print(queue[i] + " ");

        }

        System.out.println();
    }
}