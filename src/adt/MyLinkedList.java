package adt;

/*
Takes O(n) to iterate the LinkedList to find the specific node
Insertion/Deletion takes O(1)
Each node holds the reference to the next node

Dummy node to prevent null exceptions on head/tail (holds value -1)

Should be able to traverse
Insert/Delete at index
Insert/Delete at the end using head/tail

This one is Singly Linked List
 */

public class MyLinkedList {
    Node head;
    Node tail;
    int size;

    public MyLinkedList(){
        head = new Node(-1);
        tail = head;
        size = 0;
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
            Node temp = head;
            for(int i = 0; i < size-1;i++){
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
            --size;
        }
    }

    public void addIndex(int index, Node node){
        if(index == 0){
            addHead(node);
        }
        else if(index == size){
            addTail(node);
        }
        else{
            Node temp = head;
            for(int i = 0; i < index; i++){
                temp = temp.next;
            }
            node.next = temp.next;
            temp.next = node;
            ++size;
        }
    }

    public void deleteIndex(int index){
        if(index == 0){
            deleteHead();
        }
        else if(index == size-1){
            deleteTail();
        }
        else{
            Node temp = head;
            for(int i = 0; i < index; i++){
                temp = temp.next;
            }
            temp.next = temp.next.next;
            --size;
        }
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

    class Node{
        int value;
        Node next;

        public Node(int value){this.value = value;}
        public Node(){this(826);}

        public void showValue(){
            System.out.println("This node holds the value: " + this.value);
        }
    }

    public static void main(String[] args){

    }
}
