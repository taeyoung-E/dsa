package problems.arrays.question23;

import java.util.Scanner;

public class Main {
    public int solution(int[][] input){
        int[] count = new int[input.length];

        for(int i = 0; i < input.length; i++){
            for(int j = 0; j < input.length; j++){
                if(i == j) continue;
                for(int k = 0; k < 5; k++){
                    if(input[i][k] == input[j][k]){
                        count[i]++;
                        break;
                    }
                }
            }
        }
        int maxValue = count[0];
        int maxIndex = 0;
        for(int l = 1; l < count.length; l++){
            if(count[l] > maxValue){
                maxIndex = l;
                maxValue = count[l];
            }
        }
        return maxIndex + 1;
    }

    public static void main(String[] args) {
        Main t = new Main();
        Scanner sc = new Scanner(System.in);

        int numberOfStudents = sc.nextInt();
        int[][] input = new int[numberOfStudents][5];
        for(int i = 0; i < input.length; i++)
            for(int j = 0; j < input[i].length; j++){
                input[i][j] = sc.nextInt();
            }

        System.out.println(t.solution(input));
    }
}
