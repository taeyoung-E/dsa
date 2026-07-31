package problems.hash.question3;

import java.util.*;

//Finding the count of unique values given range

public class Main {
    public void solution(int[] value,int windowSize){
        Map<Integer,Integer> temp = new HashMap<>();
        int left = 0, right = windowSize;

        for(int i = 0; i < windowSize; i++){
            temp.put(value[i], temp.getOrDefault(value[i],0)+1);
        }
        System.out.printf("%d ", temp.size());

        while(right < value.length){
            if(temp.containsKey(value[left])){
                temp.put(value[left], temp.get(value[left]) - 1);
                if(temp.get(value[left]) <= 0){
                    temp.remove(value[left]);
                }
            }
            temp.put(value[right],temp.getOrDefault(value[right],0)+1);
            System.out.printf("%d ", temp.size());
            right++;
            left++;
        }



    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main t = new Main();

        int size = sc.nextInt();

        int[] test = new int[size];
        int k = sc.nextInt();

        for(int i = 0; i < test.length; i++){
            test[i] = sc.nextInt();
        }

        t.solution(test,k);
    }
}
