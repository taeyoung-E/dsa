package problems.arrays.question13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public void solution(List<Integer> input){
        System.out.print(input.get(0) + " ");
        for(int i = 1; i < input.size(); i++){
            if(input.get(i) > input.get(i -1)){
                System.out.print(input.get(i) + " ");
            }
        }
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main t = new Main();

        int count = scanner.nextInt();
        List<Integer> container = new ArrayList<>();

        for(int i = 1; i <= count; i++){
            container.add(scanner.nextInt());
        }

        t.solution(container);


    }
}
