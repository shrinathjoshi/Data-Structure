import java.util.List;
import com.util.queue.MyQueue;

/**
 * MyQueueDemo
 */
public class MyQueueDemo {

    public static void main(String[] args) {
        
        MyQueue<Integer> queue = new MyQueue<>(); 
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        
        displayQueueContents(queue);

        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.peek());
        System.out.println(queue.remove());
    }

    private static void displayQueueContents(MyQueue<Integer> myQueue) {

        List<Integer> result =  myQueue.printQueue();
        if(result.size() != 0 )
            System.out.print("Queue :- ");
            for (Integer s :result) {
                System.out.print(s+ " ");
            }
        System.out.println();
    }

}

/*
OUTPUT:-
Queue :- 1 2 3 4 
1
2
3
3

*/