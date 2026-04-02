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
        else{
            Node temp = tail.prev;
            temp.next = node;
            node.prev = temp;
            node.next = tail;
            tail.prev = node;
            ++size;
        }
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
            Node temp = tail.prev.prev;
            temp.next = tail;
            tail.prev = temp;
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
        else{ // You can find the distance between the index to head/tail to find out which way is faster to traverse
            int dh = index; // Distance from 0th index to the index
            int dt = (size - 1) - index; // Distance from the last index to the index
            // Whichever is closer will decide the traversing direction
            if(dh < dt){
                Node temp = head;
                for(int i = 0; i < index; i++){
                    temp = temp.next;
                }
                node.next = temp.next;
                temp.next.prev = node;
                temp.next = node;
                node.prev = temp;
                ++size;
            }
            else if(dt < dh){
                Node temp = tail;
                for(int i = 0; i < size-index; i++){
                    temp = temp.prev;
                }
                node.prev = temp.prev;
                temp.prev.next = node;
                node.next = temp;
                temp.prev = node;
                ++size;
            }
            else{
                Node temp = head;
                for(int i = 0; i < index; i++){
                    temp = temp.next;
                }
                node.next = temp.next;
                temp.next.prev = node;
                temp.next = node;
                node.prev = temp;
                ++size;
            }
        }
    }

    public void deleteIndex(int index){
        int dh = index;
        int dt = (size - 1) - index;
        if(dh == 0){
            deleteHead();
        }
        else if(dh < dt){
            Node temp = head;
            for(int i = 0; i < index; i++){
                temp = temp.next;
            }
            Node skip = temp.next.next;
            skip.prev = temp;
            temp.next = skip;
            --size;
        }
        else if(dt < dh){
            Node temp = tail;
            for(int i = 0; i < size-index-1; i++){
                temp = temp.prev;
            }
            Node skip = temp.prev.prev;
            temp.prev = skip;
            skip.next = temp;
            --size;
        }
        else{
            Node temp = head;
            for(int i = 0; i < index; i++){
                temp = temp.next;
            }
            Node skip = temp.next.next;
            temp.next = skip;
            skip.prev = temp;
            --size;
        }
    }

    public void showAllValue(){
        if(size == 0){
            System.out.println("No elements to display");
        }
        else{
            Node temp = head.next;
            while(temp != tail){
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
