package adt;

/*
Circular queue implementation

Shifts the index using modulus operation to start from the beginning again

But since it's hard to cover the case where queue is empty and front and rear are in the same spot,
just set the rear index to 0 when the count reaches the capacity

 */

public class MyQueueArrCircular {
    public int[] capacity;
    public int front;
    public int rear;
    public int size;

    public MyQueueArrCircular(int contentSize){
        capacity = new int[contentSize];
        front = 0;
        rear = 0;
        size = 0;
    }

    //If you keep enqueuing and rear becomes a same position front,then you know queue is full
    public void enqueue(int data){
        if(size == capacity.length){
            System.out.println("Queue is full");
        }
        else if(size == 0){
            capacity[rear++] = data;
            size++;
        }

        else if(rear == capacity.length){
            rear = 0;
            capacity[rear++] = data;
            ++size;
        }

        else if(rear == front){
            System.out.println("Queue is full, try dequeuing before enqueing");
        }

        else{
            capacity[rear++] = data;
            ++size;
        }
    }

    public int dequeue(){
        if(size == 0){
            System.out.println("There are no elements");
            return -1;
        }
        else if(front == capacity.length){
            front = 0;
            size--;
            return capacity[front++];
        }
        else{
            size--;
            return capacity[front++];
        }
    }

    public int peek() {
        if (size == 0) {
            System.out.println("No elements in the queue");
            return -1;
        }
        return capacity[front];
    }
    public static void main(String[] args) {
        MyQueueArrCircular queue = new MyQueueArrCircular(3);

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

        System.out.println("=== dequeue 10, 20 ===");
        System.out.println(queue.dequeue()); // 10
        System.out.println(queue.dequeue()); // 20

        System.out.println("=== enqueue 40 circular reuse ===");
        queue.enqueue(40);
        System.out.println(queue.peek()); // 30

        System.out.println("=== dequeue all ===");
        System.out.println(queue.dequeue()); // 30
        System.out.println(queue.dequeue()); // 40
        queue.dequeue(); // empty
        System.out.println("size: " + queue.size); // 0
    }
}
