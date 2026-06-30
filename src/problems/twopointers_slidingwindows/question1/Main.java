package problems.twopointers_slidingwindows.question1;

import java.util.Arrays;
import java.util.Scanner;

//Combining 2 sorted arrays in ascending order

public class Main {
    public void solution(int[] input1, int[] input2){
        int[] solution = new int[input1.length + input2.length];
        int left = 0, right = 0; //Left represents input1 pointer, Right represents input2 pointer
        int indexCount = 0;

        while(left < input1.length && right < input2.length){
            if(input1[left] <= input2[right]){
                solution[indexCount] = input1[left];
                left++;
                indexCount++;
            }
            else{
                solution[indexCount] = input2[right];
                right++;
                indexCount++;
            }
        }
        if(left < input1.length){
            for(int i = left; i < input1.length; i++){
                solution[indexCount++] = input1[i];
            }
        }
        else if(right < input2.length){
            for(int i = right; i < input2.length; i++){
                solution[indexCount++] = input2[i];
            }
        }
        for(int i = 0; i < solution.length; i++){
            if(i == solution.length - 1){
                System.out.print(solution[i]);
            }
            else{
                System.out.print(solution[i] + " ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main t = new Main();
        int[] firstArray = new int[sc.nextInt()];
        for(int i = 0; i < firstArray.length; i++){
            firstArray[i] = sc.nextInt();
        }

        int[] secondArray = new int[sc.nextInt()];
        for(int i = 0; i < secondArray.length; i++){
            secondArray[i] = sc.nextInt();
        }
        t.solution(firstArray,secondArray);
    }
}
