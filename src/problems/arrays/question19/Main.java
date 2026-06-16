package problems.arrays.question19;

import java.util.Scanner;
//Calculating the total points given based on how many questions were right in a row

public class Main {
    public int solution(int[] input){
        int total = 0;
        int bonus = 0;
        for(int i = 0; i < input.length; i++){
            if(input[i] == 1){
                total += 1 + bonus;
                bonus++;
            }
            else{
                bonus = 0;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main t = new Main();
        int size = sc.nextInt();

        int[] container = new int[size];
        for(int i = 0; i < container.length; i++){
            container[i] = sc.nextInt();
        }
        System.out.println(t.solution(container));
    }
}
