import java.util.Scanner;

import com.util.heap.HeapSort;

class HeapSortSimulation {

    public static void main(String[] args) {
        
        int arr[]={0,5,3,26,13,45,28};

        HeapSort sort = new HeapSort();
        sort.sort(arr);

        for(int i :arr)
            System.out.print(i + " ");

    }
}


/*
OUTPUT:-
0 3 5 13 26 28 45 
*/
