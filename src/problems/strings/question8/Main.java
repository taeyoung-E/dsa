package problems.strings.question8;

//Valid palindrome given blank and non characters, only care about alphabet and see if it's a palindrome

import java.util.Scanner;

public class Main {
    public String solution(String input){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < input.length();i++){
            if(Character.isAlphabetic(input.charAt(i))){
                sb.append(input.charAt(i));
            }
        }
        String str = sb.toString();
        int left = 0, right = str.length() - 1;
        while(left < right){
            if(Character.toLowerCase(str.charAt(left)) != Character.toLowerCase(str.charAt(right))){
                return "NO";
            }
            left++;
            right--;
        }
        return "YES";
    }

    public static void main(String[] args) {
        Main t = new Main();

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(t.solution(input));
    }
}
