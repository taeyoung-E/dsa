package problems.twopointers_slidingwindows.question2;

import java.util.*;

public class Main {
    public void solution(int[] input1, int[] input2){
        List<Integer> solution = new ArrayList<>();
        for(int i = 0; i < input1.length; i++)
            for(int j = 0; j < input2.length; j++){
                if(input1[i] == input2[j]){
                    solution.add(input1[i]);
                }
            }
        solution.sort(null);
        for(int i : solution){
            if(i == solution.get(solution.size() - 1)){
                System.out.print(i);
            }
            else{
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        Main t = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] input = new int[n];
        for(int i = 0; i < input.length; i++){
            input[i] = sc.nextInt();
        }

        int[] input2 = new int[sc.nextInt()];
        for(int i = 0; i < input2.length; i++){
            input2[i] = sc.nextInt();
        }

        t.solution(input,input2);
    }
}
