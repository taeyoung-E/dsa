package sort;

/*
n + n-1 + n-2 + n-2 . . . + 1
Number of comparison is sum of natural number formula therefore n(n-1) / 2

!!Increasing the sorted portion from the end of the container till the container gets sorted!!

 */

import java.util.Arrays;

public class MyBubble {
    static void main() { // On duplicate, dont swap and continue
        int[] testArr = {3,4,1,5,7,9,0,2,3};
        System.out.println(Arrays.toString(testArr));
        System.out.println();
        System.out.println("After sort");
        bubbleSort(testArr);
        System.out.println(Arrays.toString(testArr));
    }

    public static void bubbleSort(int[] arr){
        for(int i = 0; i < arr.length; i++){ // Testing out descending order
            for(int j = 0; j < arr.length - 1 - i; j++){
                if(arr[j] < arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }

    }

    public static void swap(int[] arr,int index1,int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
