package adt;

/*
LinkedList implementation of
 */

public class MyStackLink {
    Node sentinel; //Dummy head
    Node tail; // // Pointer to reference the last node added in MyStackLink
    int size; // Since there are no capacity, a counter to track the number of nodes in the list

    public MyStackLink(){
        sentinel = new Node(-1);
        tail = sentinel;
        size = 0;
    }



    public void push(){

    }

    public Node pop(){
        return tail;
    }

    public Node peek(){
        return tail;
    }


    static class Node{
        Node next;
        int value;

        public Node(int value){
            this.value = value;
        }
    }
}
