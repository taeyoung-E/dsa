package adt;
/*
Stack implementation using array
 */

public class MyStackArr {
    public int[] container;
    public int capacity;
    public int top;

    public MyStackArr(int capacity){
        this.capacity = capacity;
        container = new int[capacity];
        top = -1; // Counter for fullness of the array,if it equals the size of the capacity, we know it's full
    }// Can be used for searching for the last index

    public void push(int data){
        if(top == capacity - 1)
            System.out.println("Stack is full, Can't add more elements");
        else{
            top++;
            container[top] = data;
        }
    }
    public int pop(){
        if(top == -1)
            return -1; // For simplicity in this case, normally use exception
        return container[top--];
    }
    public void peek(){
        if(top == -1){
            System.out.println("No elements to show");
        }
        else{
            System.out.println("The value is " + container[top]);
        }
    }

    public static void main(String[] args) {
        MyStackArr stack = new MyStackArr(3);

        System.out.println("=== Empty pop/peek ===");
        stack.pop();
        stack.peek();

        System.out.println("=== push 10, 20, 30 ===");
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.peek(); // 30

        System.out.println("=== push when full ===");
        stack.push(40);

        System.out.println("=== pop ===");
        System.out.println(stack.pop()); // 30
        System.out.println(stack.pop()); // 20
        stack.peek(); // 10

        System.out.println("=== pop last ===");
        System.out.println(stack.pop()); // 10
        stack.pop(); // empty
    }
}
