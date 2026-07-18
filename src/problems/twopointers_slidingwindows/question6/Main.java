package problems.twopointers_slidingwindows.question6;

import java.util.Scanner;

/**
 * Maximum substring given k value to change 0 to 1
 */
public class Main {
    public int solution(int[] arr,int k){
        int max = 0;
        int left = 0;
        int constraint = 0;

        for(int right = 0; right < arr.length; right++){
            if(arr[right] == 0){
                constraint++;
            }

            while(constraint > k){
                if(arr[left] == 0){
                    constraint--;
                }
                left++;
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }

    public static void main(String[] args) {
        Main t = new Main();
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int k = sc.nextInt();

        int[] container = new int[size];

        for(int i = 0; i < container.length; i++){
            container[i] = sc.nextInt();
        }

        System.out.println(t.solution(container,k));
    }

}
