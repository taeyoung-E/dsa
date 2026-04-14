package adt;

public class MyQueueLink {
    Node front;
    Node rear;
    int capacity;

    public MyQueueLink(){
        front = new Node(-1);
        rear = new Node(-1);
        front.next = rear;
        rear.prev = front;
        capacity = 0;
    }

    public void enqueue(Node data){
        if(capacity == 0){
            Node temp = data;
            front.next = temp;
            temp.prev = front;
            temp.next = rear;
            rear.prev = temp;
            ++capacity;
        }
        else{
            Node temp = rear.prev;
            rear.prev = data;
            data.next = rear;
            data.prev = temp;
            temp.next = data;
            ++capacity;
        }
    }

    public Node dequeue(){
        if(capacity == 0){
            System.out.println("Nothing to return");
            return front;
        }
        else{
            Node temp = front.next;
            front.next = temp.next;
            temp.next.prev = front;
            --capacity;
            return temp;
        }
    }

    public void showQueue(){
        if(capacity == 0){
            System.out.println("There are no elements in the queue");
            return;
        }
        Node temp = front.next;
        while(temp != rear){
            System.out.println(temp.showValue());
            temp = temp.next;
        }
    }

    static class Node{
        Node next;
        Node prev;
        int value;


        public Node(int value){
            this.next = null;
            this.prev = null;
            this.value = value;
        }

        public String showValue(){
            return "Node Value: " + value;
        }

    }
    public static void main(String[] args) {
        MyQueueLink queue = new MyQueueLink();

        // 1. 빈 큐 출력
        System.out.println("=== Empty queue ===");
        queue.showQueue();

        // 2. 빈 큐 dequeue
        System.out.println("\n=== Dequeue on empty ===");
        queue.dequeue();

        // 3. enqueue 3개
        System.out.println("\n=== Enqueue 10, 20, 30 ===");
        queue.enqueue(new Node(10));
        queue.enqueue(new Node(20));
        queue.enqueue(new Node(30));
        queue.showQueue();

        // 4. FIFO 확인
        System.out.println("\n=== Dequeue x2 (expect 10, 20) ===");
        System.out.println("Out: " + queue.dequeue().showValue());
        System.out.println("Out: " + queue.dequeue().showValue());
        queue.showQueue();

        // 5. 마지막 노드 제거 후 재enqueue
        System.out.println("\n=== Dequeue last, re-enqueue 99 ===");
        queue.dequeue();
        queue.showQueue();
        queue.enqueue(new Node(99));
        queue.showQueue();
    }
}
