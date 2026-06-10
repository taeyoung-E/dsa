package problems.arrays.question14;

// Question where current value has to be strictly larger than the prev values to be counted

import java.util.Scanner;

public class Main {
    public void solution(int[] arr){
        int count = 1;
        int index = 1;
        int max = arr[0];
        while(index < arr.length){
            if(arr[index] > max){
                max = arr[index];
                count++;
                index++;
            }
            else{
                index++;
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        Main t = new Main();
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        int[] values = new int[input];

        for(int i = 0; i < values.length; i++){
            values[i] = scanner.nextInt();
        }

        t.solution(values);
    }
}
