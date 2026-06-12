package problems.arrays.question17;


//List the count of primes in a given range min  2 <= N <= 200,000
//Eratosthenes
//First square root the input value, only increment by the prime value lower than that root value

import java.util.Scanner;

public class Main {
    public int solution(int input){
        if(input == 2)
            return 1;
        boolean[] isNotPrime = new boolean[input + 1]; //This way, index can be matched with the array
        isNotPrime[0] = true;
        isNotPrime[1] = true;

        for(int i = 2; i * i <= input; i++){
            if(isNotPrime[i])
                continue;
            for(int j = i + i; j <= input; j += i){
                isNotPrime[j] = true;
            }
        }
        int count = 0;
        for(int i = 0; i < isNotPrime.length; i++){
            if(!isNotPrime[i])
                count++;
        }
        return count;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main t = new Main();
        int input = scanner.nextInt();
        System.out.println(t.solution(input));
    }
}
