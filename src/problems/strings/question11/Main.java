package problems.strings.question11;

//Tip is to use the sentinel character at the end to flush the result clearly

import java.util.Scanner;

public class Main {
    public String solution2(String input){
        String sentinel = input + '\0';
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int count = 1;
        for(i = 0; i < sentinel.length() - 1; i++){
            if(sentinel.charAt(i) == sentinel.charAt(i+1)){
                count++;
            }
            else{
                if(count == 1){
                    sb.append(sentinel.charAt(i));
                }
                else{
                    sb.append(sentinel.charAt(i));
                    sb.append(count);
                    count = 1;
                }
            }
        }
        return sb.toString();
    }

    public String solution(String input){
        StringBuilder sb = new StringBuilder();
        int count = 0;
        char[] container = input.toCharArray();
        int left = 0, right = left;

        while(right < container.length){
            if(container[right] == container[left]){
                count++;
                right++;
            }
            else if(container[right] != container[left]){
                if(count == 1){
                    sb.append(container[left]);
                }
                else{
                    sb.append(container[left]);
                    sb.append(count);
                }
                count = 0;
                left = right;
            }
        }
        if(count == 1){
            sb.append(container[left]);
        }
        else{
            sb.append(container[left]);
            sb.append(count);
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        Main t = new Main();
        Scanner scanner = new Scanner(System.in);
        System.out.println(t.solution2(scanner.nextLine()));
    }
}
