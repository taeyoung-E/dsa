package problems.strings.question12;

import java.util.Scanner;

public class Main {
    public String solution(int charAmount, String input){
        char[] container = new char[input.length()];
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == '#'){
                container[i] = '1';
            }
            else if(input.charAt(i) == '*'){
                container[i] = '0';
            }
        }

        StringBuilder sb = new StringBuilder();
        StringBuilder answer = new StringBuilder();

        for(int j = 0; j < container.length; j++){
            sb.append(container[j]);
            if(sb.length() == 7){
                int decimal = Integer.parseInt(sb.toString(),2);
                answer.append((char)(decimal));
                sb = new StringBuilder();
            }


        }

        return answer.toString();
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int charCount = scanner.nextInt();
        String input = scanner.next();

        Main t = new Main();
        System.out.println(t.solution(charCount,input));

    }
}
