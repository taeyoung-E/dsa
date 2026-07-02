package problems.twopointers_slidingwindows.question3;

import java.util.Scanner;

/**
 * Maximum Profit
 */
public class Main {
    public int solution(int[] input,int consecutiveDays){
        int max = 0;

        for(int i = 0; i < consecutiveDays; i++){
            max += input[i];
        }
        int currentSum = max;

        for(int i = consecutiveDays; i < input.length; i++){
            currentSum += input[i] - input[i - consecutiveDays];
            max = Math.max(max,currentSum);
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main t = new Main();
        int[] totalDays = new int[sc.nextInt()];
        int numberOfDays = sc.nextInt();
        for(int i = 0; i < totalDays.length; i++){
            totalDays[i] = sc.nextInt();
        }

        System.out.println(t.solution(totalDays,numberOfDays));
    }
}
