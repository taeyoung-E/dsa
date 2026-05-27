package problems.strings.question3;

// If the input is empty, return empty string;
// Save the first word as stringbuilder and find the index of that substring
// and start iterating except for that string,everytime you meet a space,
// stop appending and check the length between the first substring and the current one

import java.util.Scanner;

public class Main {
    public String solution(String input){
        if(input.isEmpty()){
            return "";
        }
        StringBuilder solution = new StringBuilder();
        char[] arr = input.trim().toCharArray();
        for(char c : arr){
            if(c != ' '){
                solution.append(c);
            }
            else{
                break;
            }
        }

        StringBuilder temp = new StringBuilder(); // Temporary string builder to use in the loop
        for(int i = solution.length() + 1; i < arr.length; i++){
            if(arr[i] != ' '){
                temp.append(arr[i]);
            }
            else{
                if(temp.length() > solution.length()){
                    solution = new StringBuilder(temp);
                }
                temp.setLength(0);
            }
        }
        if(temp.length() > solution.length()){
            solution = new StringBuilder(temp);
        }

        return solution.toString();
    }



    public static void main(String[] args){
        Main t = new Main();
        Scanner scanner = new Scanner(System.in);
        System.out.println(t.solution(scanner.nextLine()));
    }
}
