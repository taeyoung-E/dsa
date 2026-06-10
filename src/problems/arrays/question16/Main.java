package problems.arrays.question16;

//Input will determine how many terms to print in a Fibonacci sequence


import java.util.Scanner;

public class Main {
    public void solution(int input){
        int[] container = new int[input];
        container[0] = 1;
        container[1] = 1;

        for(int i = 2; i < container.length; i++){
            container[i] = container[i - 1] + container[i - 2];
        }

        for(int i : container){
            if(i == container[container.length - 1]){
                System.out.print(i);
            }
            else{
                System.out.print(i + " ");
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main t = new Main();
        int input = sc.nextInt();

        t.solution(input);
    }
}
