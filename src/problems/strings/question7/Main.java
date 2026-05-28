package problems.strings.question7;

//Check if palindrome
// I can convert to char array and check if array content is palindrome with left and right pointer 2n
// Or I can directly check the index of the String with left and right n
// I guess based on input, I need to change to lowercase

import java.util.Scanner;

public class Main {
    public String solution(String input){
        int left = 0, right = input.length() - 1;
        String str = input.toLowerCase();

        while(left < right){
            if(str.charAt(left) != str.charAt(right)){
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
        System.out.println(t.solution(scanner.nextLine()));
    }
}
