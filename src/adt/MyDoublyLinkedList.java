package adt;

public class MyDoublyLinkedList {
    Node head;
    Node tail;
    int size;

    public MyDoublyLinkedList(){
        this.size = 0;
        head = new Node(-1); // To indicate head
        tail = new Node(-2); // To indicate tail
        head.next = tail;
        tail.prev = head;
    }

    public void addHead(Node node){
        if(size == 0){
            head.next = node;
            node.prev = head;
            node.next = tail;
            tail.prev = node;
            ++size;
        }
        else{
            Node temp = head.next;
            head.next = node;
            node.next = temp;
            temp.prev = node;
            node.prev = head;
            ++size;
        }
    }

    public void deleteHead(){
        if(size == 0){
            System.out.println("Invalid Operation: No elements to delete");
        }
        else if(size == 1){
            head.next = tail;
            tail.prev = head;
            --size;
        }
        else{
            Node temp = head.next.next;
            temp.prev = head;
            head.next = temp;
            --size;
        }
    }

    public void addTail(Node node){
        if(size == 0){
            addHead(node);
        }
        Node temp = tail.prev;
        temp.next = node;
        node.prev = temp;
        node.next = tail;
        tail.prev = node;
        ++size;
    }

    public void deleteTail(){
        if(size == 0){
            System.out.println("No items to delete");
        }
        else if(size == 1){
            head.next = tail;
            tail.prev = head;
            --size;
        }
        else{

        }
    }

    public void addIndex(int index, Node node){}

    public void deleteIndex(int index){}

    public void showAllValue(){}





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
