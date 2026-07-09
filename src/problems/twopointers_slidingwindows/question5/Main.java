package problems.twopointers_slidingwindows.question5;

import java.util.Scanner;

public class Main {
    public int solution(int input){
        int left = 1;
        int right = (input / 2) - 1;
        int temp = 0;
        int answer = 1;

        if(input % 2 == 0)
            answer = 0;

        for(int i = 1; i <= right; i++){
            temp += i;
            while(temp > input){
                temp -= left;
                left++;
            }
            if(temp == input) ++answer;
        }
        return answer;
    }

    public static void main(String[] args) {
        Main t = new Main();
        Scanner sc = new Scanner(System.in);

        System.out.println(t.solution(sc.nextInt()));
    }
}
