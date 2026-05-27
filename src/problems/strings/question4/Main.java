package problems.strings.question4;
//You can use reverse method but is that allowed? or do I have to use two pointer to flip it

import java.util.Scanner;

public class Main {
    public void solution(String[] input){
        for(int i = 0; i < input.length; i++){
            StringBuilder sb = new StringBuilder(input[i]);
            input[i] = sb.reverse().toString();
        }
    }



    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        scanner.nextLine();
        String[] inputArr = new String[number];

        for(int i = 0; i < inputArr.length; i++){
            inputArr[i] = scanner.nextLine();
        }

        Main t = new Main();
        t.solution(inputArr);

        for(String s : inputArr){
            System.out.println(s);
        }

    }
}
