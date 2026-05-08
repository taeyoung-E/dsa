package sort;

/*
Two implementations:

One that returns the first found value,and one that returns number of duplicates

Let's try both iterative and recursive
Though it seems like Recursive verison is faster, turns out it's because of JIT compiler warmup noise
 */

public class MyBinary {
    static void main() {
        int[] testArr = new int[1_000_000];

        for(int i = 0; i < 1_000_000; i++){
            testArr[i] = i;
        }
        int[] dupArr = {1,2,3,3,4,5,6,8,8,9};

        iterBinarySearch(testArr,3000000);
        System.out.println();
        reverseBinarySearch(testArr,3000000);
    }


    public static void iterBinarySearch(int[] arr,int target){
        long start = System.nanoTime();
        int mid = arr.length / 2;
        int low = 0;
        int high = arr.length - 1;

        while(low <= high){
            if(arr[mid] == target){
                System.out.println("Target found, at index: " + mid);
                long end = System.nanoTime();
                System.out.println(end-start);
                return;
            }
            else if(target > arr[mid]){
                low = mid + 1 ;
                mid = (low + high) / 2;
            }
            else if(target < arr[mid]){
                high = mid - 1;
                mid = (low + high) / 2;
            }
        }
        System.out.println("Target not found");
        long end = System.nanoTime();
        System.out.println("Time taken: " + (end - start));
        return;
    }

    public static void reverseBinarySearch(int[] arr,int target){
        long start = System.nanoTime();
        int low = 0;
        int high = arr.length - 1;
        recurBinarySearch(arr,low,high,target);
        long end = System.nanoTime();
        System.out.println("Time taken: " + (end - start));
    }

    private static void recurBinarySearch(int[] arr,int low,int high,int target){
        int mid = (low + high) / 2;
        if(low > high){
            System.out.println("Target not found");
            return;
        }
        else if(arr[mid] == target){
            System.out.println("Target found, at index: " + mid);
            return;
        }
        else if(target > arr[mid]){
            low = mid + 1;
            recurBinarySearch(arr,low,high,target);
        }
        else if(target < arr[mid]){
            high = mid - 1;
            recurBinarySearch(arr,low,high,target);
        }
    }
    /*
    How many dups and first occurence or last occurence implementations
    using lower/upper bounds
     */

    public static void duplicateBinarySearch(int[] arr,int target){

    }

}
