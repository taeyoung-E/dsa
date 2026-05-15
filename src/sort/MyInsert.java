package sort;

import java.util.Arrays;

/**
 * Outer controls the boundary of the loop,while inside loop checks if swap is possible within the range by
 * comparing the value
 *
 * O(n^2) Time complexity
 * Since no extra space is allocated proportional to the input,space complexity is O(1)
 */

public class MyInsert {

    public static void main(String[] args) {
        int[] arr = {8, 3, 1, 7, 0, 10, 2};
        System.out.println("Before: " + Arrays.toString(arr));
        insertionSort(arr);
        System.out.println("After:  " + Arrays.toString(arr));
    }

    public static void insertionSort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            int temp = arr[i];
            int j = i - 1;

            while(j >= 0 && arr[j] > temp){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }
}
