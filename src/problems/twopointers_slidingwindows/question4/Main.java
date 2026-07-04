package problems.twopointers_slidingwindows.question4;

import java.util.Scanner;

/**
 * Consecutive sequence
 *
 * If smaller, move right pointer
 * If bigger, move left pointer
 * If same, record and move both
 */

public class Main {
    public int solution(int[] input1, int input2){
        int answer = 0;
        int constraint = input2;
        int currentSum = 0;
        int left = 0;

        for(int right = 0; right < input1.length; right++){
            currentSum += input1[right];
            if(currentSum == constraint) ++answer;
            while(currentSum >= constraint){
                currentSum -= input1[left++];
                if(currentSum == constraint) answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] input = new int[sc.nextInt()];
        int input2 = sc.nextInt();

        for(int i = 0; i < input.length; i++){
            input[i] = sc.nextInt();
        }

        Main t = new Main();

        System.out.println(t.solution(input,input2));
    }

}
