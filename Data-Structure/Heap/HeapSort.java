package com.util.heap;

/**
 * HeapSort.java
 * @author Shrinath Joshi
 * 
 * HeapSort is an in place sorting algorithm with a running time of O(nlogn)
 * 
 */
public class HeapSort {

    int heapsize =0;

    public void sort(int[] arr) {

        BUILD_MAX_HEAP(arr);
        for(int i =arr.length-1;i>0;i--)
        {
            swap(1,i,arr);
            this.heapsize--;
            MAX_MAXHEAPIFY(arr,1);
        }
    }

    private void BUILD_MAX_HEAP(int[] arr) {
        int n = arr.length-1;
        this.heapsize=n;
        for(int i=n/2;i>0;i--)
            MAX_MAXHEAPIFY(arr,i);
    }

    private void MAX_MAXHEAPIFY(int[] arr, int i) {
        int left = 2*i;
        int right = 2*i+1;

        int largest =i;

        if(left<=this.heapsize && arr[left]>arr[i])
            largest=left;
        
        if(right<=this.heapsize && arr[right] >arr[largest])
            largest=right;
        
        if(largest != i){
            swap(largest,i,arr);
            MAX_MAXHEAPIFY(arr, largest);
        }
    }

    private void swap(int i, int j,int arr[]) {
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
