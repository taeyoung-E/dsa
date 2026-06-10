package problems.arrays.question15;

//Roc,Paper,Scissor Output

import java.util.Scanner;

public class Main {
    public void solution(int[] playerA, int[] playerB){
        for(int i = 0; i < playerA.length; i++){
            int diff = Math.abs(playerA[i] - playerB[i]);
            if(diff == 0){
                System.out.println("D");
            }
            else if(diff == 1){
                System.out.println((playerA[i] > playerB[i]) ? "A" : "B");
            }
            else{
                System.out.println((playerA[i] < playerB[i]) ? "A" : "B");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main t = new Main();

        int numberOfGames = sc.nextInt();
        int[] playerA = new int[numberOfGames];
        int[] playerB = new int[numberOfGames];

        for(int i = 0; i < numberOfGames; i++){
            playerA[i] = sc.nextInt();
        }

        for(int i = 0; i < numberOfGames; i++){
            playerB[i] = sc.nextInt();
        }

        t.solution(playerA,playerB);
    }
}
