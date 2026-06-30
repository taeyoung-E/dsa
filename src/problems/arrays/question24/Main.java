package problems.arrays.question24;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Mentor Question
 */

public class Main {
    public int solution(int[][] input){
        int possibilities = 0;
        int numberOfTests = input.length;
        int numberOfStudents = input[0].length;

        for(int i = 1; i <= numberOfStudents; i++)
            for(int j = 1; j <= numberOfStudents; j++){
                if(i == j)
                    continue; //Because Mentor and Mentee can't be same
                int count = 0; //The number of tests that matches the condition

                for(int k = 0; k < numberOfTests; k++){
                    int mentor = 0;
                    int mentee = 0;

                    for(int findStudent = 0; findStudent < numberOfStudents; findStudent++ ){
                        if(input[k][findStudent] == i) mentor = findStudent;
                        if(input[k][findStudent] == j) mentee = findStudent;
                    }

                    if(mentor < mentee){
                        count++;
                    }
                    else{
                        break;
                    }
                }
                if(count == numberOfTests) possibilities++;
            }
        return possibilities;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main t = new Main();
        int studentNum = sc.nextInt();
        int numberOfTests = sc.nextInt();

        int[][] arr = new int[numberOfTests][studentNum];
        for(int i = 0; i < arr.length; i++)
            for(int j = 0; j < arr[i].length; j++){
                arr[i][j] = sc.nextInt();
            }
        System.out.println(t.solution(arr));
    }




}
