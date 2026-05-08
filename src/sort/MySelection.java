package sort;

import java.util.Arrays;

/**
 * Similar to Bubble sort except,you traverse through the entire search range first before swapping it
 * Remember the min/max index and swap it with the currently pointed
 * Outer stops at 2nd last index,and inner goes < array.length to point to the very last value in the array
 *
 * Also O(n^2) since it works like bubble sort except for the swap count (1 per outer in this case)
 */

public class MySelection {
    static void main() {
        int[] testArr = {16,3,2,67,9,2,1,8,4,2,8};
        System.out.println(Arrays.toString(testArr));
        System.out.println();
        System.out.println("After Sorting");
        selectionSort(testArr);
        System.out.println(Arrays.toString(testArr));
    }

    public static void selectionSort(int[] arr){
        for(int i = 0;i < arr.length - 1;i++){
            int minIndex = i;
            for(int j = i+1; j < arr.length; j++){
                if(arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            swap(arr,i,minIndex);
        }
    }


    public static void swap(int[] arr,int index1,int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}


