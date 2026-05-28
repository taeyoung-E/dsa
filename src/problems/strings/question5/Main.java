package problems.strings.question5;

import java.util.Scanner;

public class Main {
    public String solution(String input){
        char[] arr = input.toCharArray();
        int l = 0, r = arr.length - 1;

        while(l < r){
            if(Character.isAlphabetic(arr[l]) && Character.isAlphabetic(arr[r])){
                char temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
                l++;
                r--;
            }
            else if((!Character.isAlphabetic(arr[l])) && Character.isAlphabetic(arr[r])){
                l++;
            }
            else if(Character.isAlphabetic(arr[l]) && (!Character.isAlphabetic(arr[r]))){
                r--;
            }
            else{
                l++;
                r--;
            }
        }

        return String.valueOf(arr);
    }


    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Main t = new Main();
        String input = scanner.nextLine();
        System.out.println(t.solution(input));
    }
}
