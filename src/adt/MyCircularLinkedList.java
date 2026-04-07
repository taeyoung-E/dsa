package adt;

/*
Implement using sentinel node

If you're given a problem where you're iterating more than the size,
You can find where the node is located by finding the offset from the head using
mod operation. Iteration Count % size = Offset from head
 */

public class MyCircularLinkedList {
    Node sentinel;
    int size;

    public MyCircularLinkedList(){
        sentinel = new Node(-1);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public void addTail(Node node){
        if(size == 0){
            sentinel.next = node;
            sentinel.prev = node;
            node.next = sentinel;
            node.prev = sentinel;
            ++size;
        }
        else{
            sentinel.prev.next = node;
            node.prev = sentinel.prev;
            node.next = sentinel;
            sentinel.prev = node;
            ++size;
        }
    }

    public void addHead(Node node){
        if(size == 0){
            sentinel.next = node;
            sentinel.prev = node;
            node.next = sentinel;
            node.prev = sentinel;
            ++size;
        }
        else{
            Node oldHead = sentinel.next;
            oldHead.prev = node;
            sentinel.next = node;
            node.next = oldHead;
            node.prev = sentinel;
            ++size;
        }
    }

    public void removeTail(){
        if(size == 0){
            System.out.println("Invalid Operation, there are no elements");
        }
        else if(size == 1){
            sentinel.next = sentinel;
            sentinel.prev = sentinel;
            size--;
        }
        else{
            Node temp = sentinel.prev.prev;
            temp.next = sentinel;
            sentinel.prev = temp;
            size--;
        }
    }

    public void removeHead(){
        if(size == 0){
            System.out.println("Invalid Operation, there are no elements");
        }
        else if(size == 1){
            sentinel.next = sentinel;
            sentinel.prev = sentinel;
            size--;
        }
        else{
            Node temp = sentinel.next.next;
            temp.prev = sentinel;
            sentinel.next = temp;
            size--;
        }
    }

    public void display(){
        Node start = sentinel.next;
        while(start!=sentinel){
            System.out.print(start.value + " ");
            start = start.next;
        }
        System.out.println();
    }



    static class Node{
        Node next;
        Node prev;
        int value;

        public Node(int value){
            this.value = value;
        }
    }

    public static void main(String[] args) {
        MyCircularLinkedList list = new MyCircularLinkedList();

        System.out.println("=== Empty remove ===");
        list.removeHead();
        list.removeTail();

        System.out.println("=== addTail 1,2,3 ===");
        list.addTail(new Node(1));
        list.addTail(new Node(2));
        list.addTail(new Node(3));
        list.display(); // 1 2 3

        System.out.println("=== addHead 0 ===");
        list.addHead(new Node(0));
        list.display(); // 0 1 2 3

        System.out.println("=== removeHead ===");
        list.removeHead();
        list.display(); // 1 2 3

        System.out.println("=== removeTail ===");
        list.removeTail();
        list.display(); // 1 2

        System.out.println("=== remove until 1 ===");
        list.removeTail();
        list.display(); // 1

        System.out.println("=== remove last ===");
        list.removeHead();
        list.display(); // (빈 줄)
        System.out.println("size: " + list.size); // 0
    }
}
