package problems.strings.question10;

//O(n) solution by for looping twice

/**
 * First use arbitrary value from the start point and when you meet target character,
 * reset the counter to 0 and start counting again.
 * On the 2nd iteration, loop backward and use minimum value to set the index
 */

import java.util.Scanner;

public class Main2 {
    public void solution(String input, char c){
        int counter = 1000;
        int[] answer = new int[input.length()];

        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == c){
                counter = 0;
                answer[i] = counter;
            }
            else{
                counter++;
                answer[i] = counter;
            }
        }
        counter = 1000;

        for(int i = input.length() - 1; i >= 0; i--){
            if(input.charAt(i) == c){
                counter = 0;
                answer[i] = counter;
            }
            else{
                ++counter;
                answer[i] = Math.min(counter,answer[i]);
            }
        }
        for(int i = 0; i < answer.length;i++){
            if(i == answer.length-1){
                System.out.print(answer[i]);
            }
            else{
                System.out.print(answer[i] + " ");
            }
        }
    }

    public static void main(String[] args) {
        Main2 t = new Main2();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        char c = scanner.next().charAt(0);
        t.solution(input,c);
    }
}
