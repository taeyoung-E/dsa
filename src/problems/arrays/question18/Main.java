package problems.arrays.question18;

import java.util.Scanner;

//Reversing the given natural number and output the value if it's a prime


//Maybe use modulus by 10
//Basically parse a value and see if it's a prime
//First parse the last digit by modulo operator and multiply it by the
//correct digit placement

//Then use the

public class Main {
    public boolean isPrime(int value){
        if(value == 2) return true;
        if(value == 1) return false;
        if(value % 2 == 0)
            return false;
        int range = (int)Math.sqrt(value);
        for(int i = 3; i <= range; i += 2){
            if(value % i == 0)
                return false;
        }
        return true;
    }

    public void solution(int[] arr){
        boolean firstNumber = true;
        for(int i = 0; i < arr.length; i++){
            int value = 0;
            int temp = arr[i];

            while(temp > 0){
                int last = temp % 10;
                value = value * 10 + last;
                temp /= 10;
            }
            if(isPrime(value)){
                if(!firstNumber){
                    arr[i] = value;
                    System.out.print(" " + arr[i]);
                }
                else{
                    arr[i] = value;
                    System.out.print(arr[i]);
                    firstNumber = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main t = new Main();

        int size = sc.nextInt();
        int[] inputContainer = new int[size];
        for(int i = 0; i < inputContainer.length; i++){
            inputContainer[i] = sc.nextInt();
        }

        t.solution(inputContainer);

    }
}
