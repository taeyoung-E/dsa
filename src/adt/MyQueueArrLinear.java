package adt;

/*
Enqueue from the rear and dequeue from the front
Always O(1)

Can't really reuse empty spaces like Circular queue, needs to reset


 */

public class MyQueueArrLinear {
    public int[] capacity;
    public int front;
    public int rear;

    public MyQueueArrLinear(int size){
        capacity = new int[size];
        front = 0;
        rear = 0;
    }

    public void reset(){
        front = 0;
        rear = 0;
    }

    public void enqueue(int value){
        if(rear == capacity.length){
            System.out.println("Queue is full,try resetting");
        }
        else{
            capacity[rear++] = value;
        }
    }

    public int dequeue(){
        if(front == rear){
            System.out.println("Queue is empty, try resetting");
            return -1;
        }
        else{
            return capacity[front++];
        }
    }

    public int peek(){
        if(front == rear){
            System.out.println("There are no elements to peek");
            return -1;
        }
        return capacity[front];
    }

    public static void main(String[] args) {
        MyQueueArrLinear queue = new MyQueueArrLinear(3);

        System.out.println("=== Empty dequeue/peek ===");
        queue.dequeue();
        queue.peek();

        System.out.println("=== enqueue 10, 20, 30 ===");
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println(queue.peek()); // 10

        System.out.println("=== enqueue when full ===");
        queue.enqueue(40);

        System.out.println("=== dequeue ===");
        System.out.println(queue.dequeue()); // 10
        System.out.println(queue.dequeue()); // 20
        System.out.println(queue.peek());    // 30

        System.out.println("=== dequeue last ===");
        System.out.println(queue.dequeue()); // 30
        queue.dequeue(); // empty

        System.out.println("=== reset and reuse ===");
        queue.reset();
        queue.enqueue(99);
        System.out.println(queue.peek()); // 99
    }


}
