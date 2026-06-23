package problems.arrays.question21;
/*
Grid question,
Given N by N grid find the greatest sum from
adding rows, columns, or between 2 diagonals
 */

import java.util.Scanner;

public class Main {
    public int diagSum(int[][] input){
        int count = 0;
        int leftToRight = 0;
        int rightToLeft = 0;
        int endIndex = input.length - 1;
        for(int i = 0; i < input.length; i++){
            leftToRight += input[i][count]; //Adding leftToRight
            rightToLeft += input[i][endIndex];
            endIndex -= endIndex;
            count++;
        }
        return Math.max(leftToRight,rightToLeft);
    }

    public int rowSum(int[][] input){
        int temp = 0;
        int max = 0;
        for(int i = 0; i < input.length; i++){
            for(int j = 0; j < input.length; j++){
                temp += input[i][j];
            }
            max = Math.max(max,temp);
            temp = 0;
        }
        return max;
    }

    public int columnSum(int[][] input){
        int temp = 0;
        int max = 0;
        for(int column = 0; column < input.length; column++){
            for(int row = 0; row < input.length; row++){
                temp += input[row][column];
            }
            max = Math.max(temp,max);
            temp = 0;
        }
        return max;
    }

    public int solution(int[][] input){
        int diag = diagSum(input);
        int row = rowSum(input);
        int column = columnSum(input);

        int firstComparison = Math.max(diag,row);
        return Math.max(firstComparison,column);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main t = new Main();
        int size = sc.nextInt();

        int[][] input = new int[size][size];
        for(int i = 0; i < input.length; i++){
            for(int j = 0; j < input.length; j++){
                input[i][j] = sc.nextInt();
            }
        }
        System.out.println(t.solution(input));

    }
}
