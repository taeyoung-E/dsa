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
        MyLinkedList list = new MyLinkedList();

        // 1. addHead 테스트
        System.out.println("=== addHead ===");
        list.addHead(list.new Node(10));
        list.addHead(list.new Node(20));
        list.addHead(list.new Node(30));
        list.showAllValue(); // 30 20 10

        // 2. addTail 테스트
        System.out.println("=== addTail ===");
        list.addTail(list.new Node(99));
        list.addTail(list.new Node(100));
        list.showAllValue(); // 30 20 10 99 100

        // 3. addIndex 테스트
        System.out.println("=== addIndex ===");
        list.addIndex(0, list.new Node(0));   // 맨 앞
        list.addIndex(3, list.new Node(55));  // 중간
        list.addIndex(list.size, list.new Node(200)); // 맨 뒤
        list.showAllValue(); // 0 30 20 55 10 99 100 200

        // 4. deleteHead 테스트
        System.out.println("=== deleteHead ===");
        list.deleteHead();
        list.showAllValue(); // 30 20 55 10 99 100 200

        // 5. deleteTail 테스트
        System.out.println("=== deleteTail ===");
        list.deleteTail();
        list.showAllValue(); // 30 20 55 10 99 100

        // 6. deleteIndex 테스트
        System.out.println("=== deleteIndex ===");
        list.deleteIndex(2); // 중간 삭제
        list.showAllValue(); // 30 20 10 99 100

        // 7. size 확인
        System.out.println("=== size check ===");
        System.out.println("Size: " + list.size); // 5

        // 8. edge case - 원소 1개일때 deleteHead
        System.out.println("=== single element edge case ===");
        MyLinkedList single = new MyLinkedList();
        single.addHead(single.new Node(42));
        single.showAllValue(); // 42
        single.deleteHead();
        single.showAllValue(); // No elements to display
        System.out.println("Size after delete: " + single.size); // 0

        // 9. edge case - 빈 리스트에서 삭제 시도
        System.out.println("=== empty list edge case ===");
        single.deleteHead(); // Invalid operation 출력되어야 함
        single.deleteTail(); // Invalid operation 출력되어야 함

        // 10. tail 포인터 정확성 확인
        System.out.println("=== tail pointer check ===");
        MyLinkedList tailCheck = new MyLinkedList();
        tailCheck.addTail(tailCheck.new Node(1));
        tailCheck.addTail(tailCheck.new Node(2));
        tailCheck.addTail(tailCheck.new Node(3));
        System.out.println("Tail value: " + tailCheck.tail.value); // 3
        tailCheck.deleteTail();
        System.out.println("Tail after delete: " + tailCheck.tail.value); // 2
    }
}
