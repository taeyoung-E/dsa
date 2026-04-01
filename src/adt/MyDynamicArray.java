package adt;

/*
- Implemented using array
- Should dynamically increase in size by factor of 2
- Can insert/delete at the end
- Can insert/delete at index
- Can iterate and show all the values in the list
- Time complexity of O(n) for iterating through the list
- Insertion/Deleteion at the index 0(n) because it needs to shift the element
 */

import java.util.Arrays;

public class MyDynamicArray {
    public int capacity; //Number of elements in the array
    public int[] container;

    public MyDynamicArray(int size){container = new int[size];} //Constructor for Dynamic Array size
    public MyDynamicArray(){container = new int[10];} //Default size is 10

    public void regrow(){
        container = Arrays.copyOf(container,container.length *2);
    }

    public void insertEnd(int element){
        if(capacity == container.length)
            regrow();
        container[capacity++] = element;
    }

    public void deleteEnd(){
        if(capacity == 0)
            System.out.println("There's no element to delete");
        else{
            container[capacity-1] = 0;
            capacity--;
        }
    }

    public void insertIndex(int index,int value){
        if(capacity == container.length)
            regrow();
        for(int i = capacity; i > index; i--){
            container[i] = container[i-1];
        }
        container[index] = value;
        capacity++;
    }

    public void deleteIndex(int index){
        if(capacity == 0){
            System.out.println("No items to delete");
        }
        else{
            for(int i = index; i < capacity; i++){
                container[i] = container[i+1];
            }
            capacity--;
            container[capacity] = 0;
        }
    }

    public void showContent(){
        for(int i : container)
            System.out.print(i + " ");
        System.out.println();
    }




    public static void main(String[] args){
        MyDynamicArray t = new MyDynamicArray();
        t.deleteEnd();
        System.out.println(t.container.length + "Container Length");

        t.insertEnd(30);
        t.insertEnd(1);
        t.insertEnd(4);


        t.showContent();

        System.out.println();
        t.insertIndex(2,99);
        t.showContent();

        t.insertEnd(66);
        t.showContent();

        t.deleteIndex(3);
        t.showContent();
        System.out.println(t.capacity);

        for(int i = 0; i < 7; i++)
            t.insertEnd(9);

        System.out.println("Check if Array size regrew from 10 - " + t.container.length);
    }
}
