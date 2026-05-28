package problems.strings.question9;

import java.util.Scanner;

public class Main {

    public int solution(String input){
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < input.length();i++){
            if(Character.isDigit(input.charAt(i))){
                sb.append(input.charAt(i));
            }
        }

        return Integer.parseInt(sb.toString());
    }


    public static void main(String[] args) {
        Main t = new Main();

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(t.solution(input));
    }
}
