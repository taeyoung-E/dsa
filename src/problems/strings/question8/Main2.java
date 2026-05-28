package problems.strings.question8;

//Using regex and replaceAll

import java.util.Locale;
import java.util.Scanner;

public class Main2 {
    public String solution(String input){
        String filtered = input.toLowerCase().replaceAll("[^a-z]","");
        int left = 0, right = filtered.length() - 1;
        while(left < right){
            if(filtered.charAt(left) != filtered.charAt(right)){
                return "NO";
            }
            left++;
            right--;
        }
        return "YES";
    }

    public static void main(String[] args) {
        Main2 t = new Main2();

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(t.solution(input));
    }
}
