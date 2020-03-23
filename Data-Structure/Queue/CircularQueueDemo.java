import com.util.queue.CircularQueue;

/**
 * CircularQueueDemo
 */
public class CircularQueueDemo {

    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        
        queue.display();
    
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.peek());
        System.out.println(queue.remove());
    }
}

/*
OUTPUT:-
1 2 3 4 
1
2
3
3

*/