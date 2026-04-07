package adt;

/*
LinkedList implementation of a stack
Unlike Array where index moves from left to right(when added),
Think of head(sentinel node) as the pointer that can refer to tail
so right to left where left is the tail in this case when nodes are added

e.g  Sentinel -> Node to pop -> Node -> Node ...
 */

public class MyStackLink {
    Node sentinel; //Dummy head
    int size; // Since there are no capacity, a counter to track the number of nodes in the list

    public MyStackLink(){
        sentinel = new Node(-1);
        size = 0;
    }



    public void push(Node node){
        if(size == 0){
            sentinel.next = node;
            size++;
        }
        else{
            Node temp = sentinel.next;
            sentinel.next = node;
            node.next = temp;
            size++;
        }
    }

    public Node pop(){
        if(size == 0){
            System.out.println("There are no elements");
            return sentinel;
        }
        if(size == 1){
            Node temp = sentinel.next; // Node to return
            sentinel.next = null;
            size--;
            return temp;
        }
        else{
            Node temp = sentinel.next; // Node to return
            sentinel.next = sentinel.next.next;
            size--;
            return temp;
        }
    }

    public Node peek(){
        if(size == 0)
            return sentinel; // Value of -1 on the node will indicate that there's no element, use exception in real cases
        return sentinel.next;
    }


    static class Node{
        Node next;
        int value;

        public Node(int value){
            this.value = value;
        }
    }
    public static void main(String[] args) {
        MyStackLink stack = new MyStackLink();

        System.out.println("=== Empty pop/peek ===");
        System.out.println(stack.pop().value);  // -1
        System.out.println(stack.peek().value); // -1

        System.out.println("=== push 10, 20, 30 ===");
        stack.push(new Node(10));
        stack.push(new Node(20));
        stack.push(new Node(30));
        System.out.println(stack.peek().value); // 30

        System.out.println("=== pop ===");
        System.out.println(stack.pop().value); // 30
        System.out.println(stack.pop().value); // 20
        System.out.println(stack.peek().value); // 10

        System.out.println("=== pop last ===");
        System.out.println(stack.pop().value); // 10
        System.out.println(stack.pop().value); // -1 (empty)
        System.out.println("size: " + stack.size); // 0
    }
}
