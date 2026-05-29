package problems.strings.question10;

import java.util.Scanner;

//Given a string and a charcter to compare on the first line,find out how far apart each letter
// are in a given string

public class Main {
    public void solution(String input){
        char toTest = input.charAt(input.length()-1);
        String toCheck = input.substring(0,input.length() - 2); // Substring method's endIndex is exclusive
        int[] arr = new int[toCheck.length()];

        for(int i = 0; i < toCheck.length(); i++){
            int searchToRight = toCheck.indexOf(toTest,i);
            int searchToLeft = toCheck.lastIndexOf(toTest,i);
            if(searchToRight == -1){
                arr[i] = Math.abs(searchToLeft - i);
            }
            else if(searchToLeft == -1){
                arr[i] = Math.abs(searchToRight - i);
            }
            else{
                int minDistance = Math.min(Math.abs(searchToLeft - i),Math.abs(searchToRight - i));
                arr[i] = minDistance;
            }
        }
        for(int i = 0; i < arr.length;i++){
            if(i == arr.length - 1){
                System.out.print(arr[i]);
            }
            else{
                System.out.print(arr[i] + " ");
            }
        }
    }


    public static void main(String[] args) {
        Main t = new Main();
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine().trim();
        t.solution(input);
    }
}
