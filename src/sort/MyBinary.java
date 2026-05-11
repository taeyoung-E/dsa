package sort;

/*
Two implementations:

One that returns the first found value,and one that returns number of duplicates

Let's try both iterative and recursive
Though it seems like Recursive verison is faster, turns out it's because of JIT compiler warmup noise
 */

public class MyBinary {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 3, 5, 6, 7};

        System.out.println("Array: [1, 2, 3, 3, 3, 5, 6, 7]");
        System.out.println("--- Lower Bound (target = 3) ---");
        lowerBound(arr, 3); // expected: index 2

        System.out.println("--- Upper Bound (target = 3) ---");
        upperBound(arr, 3); // expected: index 4

        System.out.println("--- Lower Bound (target = 1) ---");
        lowerBound(arr, 1); // expected: index 0

        System.out.println("--- Upper Bound (target = 7) ---");
        upperBound(arr, 7); // expected: index 7

        System.out.println("--- Not found (target = 4) ---");
        lowerBound(arr, 4); // expected: does not exist
        upperBound(arr, 4); // expected: does not exist
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

    public static void lowerBound(int[] arr,int target){
        int low = 0;
        int high = arr.length - 1;
        int mid = (high + low) / 2;
        int result = -1;

        while(low <= high){
            if(arr[mid] == target){
                result = mid;
                high = mid - 1;
                mid = (low + high) / 2;
            }
            else if(arr[mid] < target){
                low = mid + 1;
                mid = (high + low) / 2;
            }
            else{
                high = mid - 1;
                mid = (high + low) / 2;
            }
        }
        if(result == -1){
            System.out.println("The value does not exist");
            return;
        }
        System.out.println("The lowest index is: " + result);
    }

    public static void upperBound(int[] arr,int target){
        int low = 0;
        int high = arr.length - 1;
        int mid = (high + low) / 2;
        int result = -1;

        while(low <= high){
            if(arr[mid] == target){
                result = mid;
                low = mid + 1;
                mid = (low + high) / 2;
            }
            else if(arr[mid] < target){
                low = mid + 1;
                mid = (high + low) / 2;
            }
            else{
                high = mid - 1;
                mid = (high + low) / 2;
            }
        }
        if(result == -1){
            System.out.println("The value does not exist");
            return;
        }
        System.out.println("The highest index is: " + result);
    }

}
