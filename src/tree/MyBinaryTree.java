package tree;


/*
A node that doesn't have a child is called a leaf node
Distance from the root node to the farthest leaf node is called a height

Height is either determined by the number of nodes including the root or
the number of edges from the root to the farthest leaf

There are 4 ways to traverse the tree

Depth First
- Inorder: Left -> Visited -> Right  Think of it as visit between traversal so "In"order
- Preorder: Visited -> Left -> Right  Think of it as visiting before traversal so "Pre"order
- Postorder Left -> Right -> Visited  Think of it as visiting after all the traversal so "Post"order

Traversed using stack (though call stack in this case cause of recursion)

Breadth First
- Level order: Enqueue Current Node -> Dequeue/Visit Current Node -> Enqueue child nodes . . . cycle continues

Implemented using queue

Insertion/Deletion is O(n) because unlike binary search tree,it needs to potentially search all nodes in worst case
 */

import adt.MyQueueLink;

import java.util.LinkedList;
import java.util.Queue;

public class MyBinaryTree {
    Node root;
    int size;

    public MyBinaryTree(Node root){ //In this case,
        this.root = root;
        this.size = 1;
    }

    public void insertNode(Node node){//Uses level order traversal to insert the node
        if(size == 0){
            root = node;
            ++size;
            return;
        }

        Queue<Node> container = new LinkedList<>();
        Node start = root;
        container.offer(start);

        while(!container.isEmpty()){//For readability
            Node check = container.poll();
            if(check.left == null){
                check.left = node;
                ++size;
                break;
            }
            else if(check.right == null){
                check.right = node;
                ++size;
                break;
            }
            else{
                container.offer(check.left);
                container.offer(check.right);
            }
        }
    }

    public void deleteNode(int targetValue){ //If size = 0, Nothing to delete so print out a mssg,if size 1, just delete root\
        // This method finds the first instance of the node value and deletes that by overwrites it with the righter most node's value
        if(size == 0){
            System.out.println("There's nothing to delete");
            return;
        }
        else if(size == 1 && (root.value == targetValue)){
            root = null;
            --size;
            System.out.println("Root was deleted");
            return;
        }
        //Find the right most node
        Queue<Node> container = new LinkedList<>();
        Node start = root;
        Node lastNode = null;
        Node lastParent = null;
        Node targetNode = null;
        Node check = null;
        container.offer(start);

        while(!container.isEmpty()){
            check = container.poll();
            if((check.value == targetValue) && (targetNode == null)){
                targetNode = check; //Found the target node
            }
            if(check.left != null){
                lastParent = check;
                lastNode = check.left;
                container.offer(check.left);
            }

            if(check.right != null){
                lastParent = check;
                lastNode = check.right;
                container.offer(check.right);
            }
        }
        if(targetNode == null){
            System.out.println("Couldn't find the target value node");
            return;
        }
        targetNode.value = lastNode.value;
        if(lastParent.right == lastNode){
            lastParent.right = null;
            size--;
        }
        else{
            lastParent.left = null;
            size--;
        }
    }

    public void preOrder(){
        if(size == 0){
            System.out.println("Nothing to print");
            return;
        }
        preOrder(root);
        System.out.println();
    }

    private void preOrder(Node node){
        if(node == null) return;
        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void postOrder(){
        if(size == 0){
            System.out.println("Nothing to print");
            return;
        }
        postOrder(root);
        System.out.println();
    }

    private void postOrder(Node node){
        if(node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }

    public void inOrder(){
        if(size == 0){
            System.out.println("Nothing to print");
            return;
        }
        inOrder(root);
        System.out.println();
    }

    private void inOrder(Node node){
        if(node == null) return;
        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }

    public void levelOrder(){
        if(size == 0){
            System.out.println("Nothing to print");
            return;
        }
        else if(size == 1){
            System.out.println(root.value);
            return;
        }
        Node start = root;
        Queue<Node> container = new LinkedList<>();
        container.offer(start);

        while(!container.isEmpty()){
            Node visit = container.poll();
            System.out.print(visit.value + " ");
            if(visit.left != null)
                container.offer(visit.left);
            if(visit.right != null)
                container.offer(visit.right);
        }
        System.out.println();
    }

    static class Node{
        Node left,right;
        int value;

        public Node(int value){
            left = null;
            right = null;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        // 1. 트리 생성
        MyBinaryTree tree = new MyBinaryTree(new Node(1));
        tree.insertNode(new Node(2));
        tree.insertNode(new Node(3));
        tree.insertNode(new Node(4));
        tree.insertNode(new Node(5));
        tree.insertNode(new Node(6));
        tree.insertNode(new Node(7));

    /*
        1
       / \
      2   3
     / \ / \
    4  5 6  7
    */

        // 2. Traversal 확인
        System.out.println("=== PreOrder (1 2 4 5 3 6 7) ===");
        tree.preOrder();

        System.out.println("=== InOrder (4 2 5 1 6 3 7) ===");
        tree.inOrder();

        System.out.println("=== PostOrder (4 5 2 6 7 3 1) ===");
        tree.postOrder();

        System.out.println("=== LevelOrder (1 2 3 4 5 6 7) ===");
        tree.levelOrder();

        // 3. Deletion - 중간 노드
        System.out.println("\n=== Delete 2 (replaced by deepest rightmost: 7) ===");
        tree.deleteNode(2);
        tree.levelOrder(); // 1 7 3 4 5 6

        // 4. Deletion - 없는 값
        System.out.println("\n=== Delete 99 (not found) ===");
        tree.deleteNode(99);

        // 5. Deletion - root
        System.out.println("\n=== Delete root until empty ===");
        tree.deleteNode(1);
        tree.deleteNode(7);
        tree.deleteNode(3);
        tree.deleteNode(4);
        tree.deleteNode(5);
        tree.deleteNode(6);
        tree.levelOrder(); // Nothing to print

        // 6. 빈 트리에 삽입 후 재확인
        System.out.println("\n=== Re-insert after empty ===");
        tree.insertNode(new Node(99));
        tree.levelOrder(); // 99
    }
}
