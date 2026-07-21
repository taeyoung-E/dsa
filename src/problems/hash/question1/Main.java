package problems.hash.question1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public char solution(String input, int size){
        Map<Character,Integer> container = new HashMap<>();
        char[] temp = input.toCharArray();

        for(char key : temp){
            container.put(key,container.getOrDefault(key,0) + 1);
        }

        int max = 0;
        char c = ' ';
        for(char key : container.keySet()){
            if(container.get(key) > max){
                c = key;
                max = container.get(key);
            }
        }
        return c;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main t = new Main();
        int input = sc.nextInt();
        sc.nextLine();

        String votes = sc.nextLine();


        System.out.println(t.solution(votes,input));

    }
}
