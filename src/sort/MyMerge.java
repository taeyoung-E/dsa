package sort;

import java.util.Arrays;

/**
 * n log n time complexity
 * Uses more space due to recursion call
 *
 * Split the original array in half, and copy the content of each partition in left/right
 * When it reaches the final split where number of element = 1;
 *
 * Start merging by comparing left and right arr with while loop using 3 counters:
 * one for original arr, one for left portion,another one for right portion
 *
 * As long as both of the counters are less than the content of the array, keep comparing
 *
 * If the first while loop ends, it means the content of one subarray is copied fully, therefore
 * just copy the leftover elements in another subarray using while loop(they're already sorted
 * therefore just copy it)
 */

public class MyMerge {
    public static void main(String[] args) {
        int[] arr = {8, 3, 1, 7, 0, 10, 2};
        System.out.println("Before: " + Arrays.toString(arr));
        mergeSort(arr);
        System.out.println("After:  " + Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr){
        int length = arr.length;
        if(length <= 1) return;

        int middle = arr.length / 2;
        int[] leftArr = new int[middle];
        int[] rightArr = new int[length - middle];

        int j = 0; // Index counter for rightArr;

        for(int i = 0; i < arr.length; i++){ // Loop to copy the content of the array for left/right subarr
            if(i < middle){
                leftArr[i] = arr[i];
            }
            else{
                rightArr[j] = arr[i];
                j++;
            }
        }
        mergeSort(leftArr);
        mergeSort(rightArr);
        merge(arr,leftArr,rightArr);

    }

    public static void merge(int[] arr,int[] left,int[] right){
        int i = 0,j = 0,k = 0; // j is for left and k is for right subarr, i is for original

        while(j < left.length && k < right.length){ // Loop to put the values in till one of the subarr is empty
            if(left[j] < right[k]){
                arr[i] = left[j];
                i++;
                j++;
            }
            else{
                arr[i] = right[k];
                i++;
                k++;
            }
        }

        while(j < left.length){
            arr[i] = left[j];
            i++;
            j++;
        }
        while(k < right.length){
            arr[i] = right[k];
            i++;
            k++;
        }

    }
}
