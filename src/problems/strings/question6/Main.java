package problems.strings.question6;

// Find the first occurence of a character in a given string, then using the for loop,
// Check if the first occurence of the character matches the current one(index) and if it is,
// then append

// indexOf(First occurence of something(character, substring)

import java.util.Scanner;

public class Main {
    public String solution(String input){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < input.length(); i++){
            if(input.indexOf(input.charAt(i)) == i){
                sb.append(input.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Main t = new Main();

        System.out.println(t.solution(input));
    }
}
