package problems.arrays.question22;

import java.util.Scanner;
//First method is to initialize the edges to 0 to make it easier


//The solution shows that you can make array of directions
// dx = [-1,0,1,0]
// dy = [0, 1, 0,-1]  // And then use increment the current index value by this
// to not write if statements (useful if you're thinking about 8 direction in future questions)

public class Main {
    public int solution(int[][] input){
        int count = 0;
        for(int i = 1; i < input.length - 1; i++){
            for(int j = 1; j < input.length - 1; j++){
                if(input[i][j] > input[i - 1][j] && input[i][j] > input[i + 1][j]
                    && input[i][j] > input[i][j-1] && input[i][j] > input[i][j+1]){
                    ++count;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Main t = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] input = new int[n + 2][n + 2];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 || j == 0 || i == n - 1 || j == n -1){
                    input[i][j] = 0;
                }
            }
        }
        for(int i = 1; i < input.length - 1; i++)
            for(int j = 1; j < input.length - 1; j++){
                input[i][j] = sc.nextInt();
            }
        System.out.println(t.solution(input));

    }
}
