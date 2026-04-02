package adt;

public class MyDoublyLinkedList {
    Node head;
    Node tail;
    int size;

    public MyDoublyLinkedList(){
        this.size = 0;
        head = new Node(-1); // To indicate head
        tail = new Node(-2); // To indicate tail
    }

    public void addHead(Node node){
        if(size == 0){
            head.next = node;
            tail = head.next;
            size++;
        }
        else{
            node.next = head.next;
            head.next = node;
            ++size;
        }
    }

    public void deleteHead(){
        if(size == 0){
            System.out.println("Invalid operation, No element to delete(Can't delete head)");
        }
        else if(size == 1){
            head.next = null;
            tail = head;
            --size;
        }
        else{
            head.next = head.next.next;
            --size;
        }
    }

    public void addTail(Node node){
        if(size == 0){
            head.next = node;
            tail = head.next;
            ++size;
        }
        else{
            tail.next = node;
            tail = node;
            ++size;
        }
    }

    public void deleteTail(){
        if(size == 0){
            System.out.println("Invalid Operation, there are no elements (Can't delete tail)");
        }
        else{
            tail = tail.prev;
            tail.next = null;
            --size;
        }
    }

    public void addIndex(int index, Node node){

    }

    public void deleteIndex(int index){

    }

    public void showAllValue(){
        if(size == 0){
            System.out.println("No elements to display");
        }
        else{
            Node temp = head.next;
            while(temp != null){
                System.out.print(temp.value + " ");
                temp = temp.next;
            }
            System.out.println("- - - - - - ");
        }
    }





    static class Node{
        int value;
        Node next;
        Node prev;

        public Node(int value){
            this.value = value;
            next = null;
            prev = null;
        }

        public Node(){
            this(826);
        }
        public void showValue(){
            System.out.println("This node holds the value: " + this.value);
        }
    }
}
