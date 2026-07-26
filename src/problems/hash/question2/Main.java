package problems.hash.question2;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

/**
 * Valid Anagram
 */

public class Main {

    public String solution(String input1,String input2){
        String s1 = input1.toLowerCase();
        String s2 = input2.toLowerCase();

        Map<Character,Integer> container = new HashMap<>();

        if(input1.length() != input2.length())
            return "NO";

        Map<Character,Integer> container2 = new HashMap<>();

        for(int i = 0; i < input1.length(); i++){
            container.put(s1.charAt(i),container.getOrDefault(s1.charAt(i),0) + 1);
        }

        for(int i = 0; i < input2.length(); i++){
            container2.put(s2.charAt(i),container2.getOrDefault(s2.charAt(i),0) + 1);
        }

        for(var key : container.keySet()){
            if(!Objects.equals(container.get(key), container2.get(key))){
                return "NO";
            }
        }
        return "YES";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main t = new Main();

        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        System.out.println(t.solution(s1,s2));
    }
}
