package sort;

/*
Pick a pivot and continue the same process in subarray till end is <= start and merge
the partitioned array to achieve sorted array

n log n avg, n^2 worst case

log n space complexity and uses stack memory

 */

import java.util.Arrays;

public class MyQuick {
    public static void main(String[] args) {
        MyQuick sorter = new MyQuick();

        int[] arr = {8, 3, 1, 7, 0, 10, 2};
        System.out.println("Before: " + Arrays.toString(arr));
        sorter.quickSort(arr, 0, arr.length - 1);
        System.out.println("After:  " + Arrays.toString(arr));
    }

    public void quickSort(int[] arr,int start,int end){
        if(end <= start) return; // Then u know there's only one element therefore, base case
        int pivot = partition(arr,start,end);
        quickSort(arr,start,pivot - 1); // Left Partition
        quickSort(arr,pivot + 1, end); // Right Partition
    }

    public int partition(int[] arr,int start,int end){ // 1 pointer that starts from as
        int pivot = arr[end];
        int i = start - 1; // 2nd pointer to track smaller range items

        for(int j = start; j < end; j++){
            if(arr[j] < pivot){
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = arr[end];
        arr[end] = temp;
        return i;
    }
}

