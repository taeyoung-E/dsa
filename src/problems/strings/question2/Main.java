package problems.strings.question2;


import java.util.Scanner;

public class Main {
    public String solution(String input){
        StringBuilder answer = new StringBuilder();

        for(char c : input.toCharArray()){
            if(Character.isUpperCase(c)){
                answer.append(Character.toLowerCase(c));
            }
            else{
                answer.append(Character.toUpperCase(c));
            }
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        Main t = new Main();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        System.out.println(t.solution(input));

    }
}
