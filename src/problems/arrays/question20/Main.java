package problems.arrays.question20;

import java.util.Scanner;

/*
Nth number of student's test score as input
Print the order based on input order
 */

public class Main {
    public void solution(int[] input){
        int[] result = new int[input.length];
        for(int i = 0; i < result.length; i++){
            int count = 1;
            for(int j = 0; j < result.length; j++){
                if(input[i] < input[j]){
                    count++;
                }
            }
            result[i] = count;
        }
        for(int value : result){
            System.out.print(value + " ");
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main t = new Main();
        int size = sc.nextInt();

        int[] input = new int[size];
        for(int i = 0; i < input.length; i++){
            input[i] = sc.nextInt();
        }
        t.solution(input);

    }
}
