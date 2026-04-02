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

    /*
    Let's try to fix in from this point, using a dummy node and using dummy node as a reference to traverse
    as well
     */

    public void insertHead(Node node){
        if(size == 0){
            head.next = node;
            head = node;
            tail = node;
            ++size;
        }
        else{
            node.next = head;
            head = node;
            ++size;
        }
    }

    public void insertTail(Node node){
        if(size == 0){
            head.next = node;
            head = node;
            tail = node;
            ++size;
        }
        else if(head == tail){
            tail.next = node;
            tail = tail.next;
            ++size;
        }
        else{
            Node temp = head;
            for(int i = 0; i < size; i++){
                temp = temp.next;
            }
            temp.next = node;
            tail = node;
            ++size;
        }
    }

    public void insertAtIndex(Node node,int index){
        if(index == 0)
            insertHead(node);
        else if(index > 0) {
            Node temp = head; //Temp to hold the node that's placed at index-1
            for (int i = 0; i < index - 1; i++) { //Just one less than the index to hold the node
                temp = temp.next;
            }
            node.next = temp.next;
            temp.next = node;
            ++size;
        }
    }

    public void deleteTail(){
        if(size == 0)
            System.out.println("Invalid Operation, there are no elements");
        else if(size > 0){
            Node temp = head; //
            for(int i = 0; i < size - 2; i++){
                temp = temp.next;
            }
            tail = temp;
            temp.next = null;
            --size;
        }
    }

    public void deleteHead(){
        if(size == 0)
            System.out.println("Invalid Operation, no elements");
        else if(size == 1){
            head = null;
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
