package tree;

/*
When value < current Node, Insert Left (But only on the node where left is null)
When value > current Node, Insert Right (But only on the node where right is null)
 */

public class MyBinarySearchTree {
    Node root;
    int size;

    public MyBinarySearchTree(Node node){
        root = node;
        size = 1;
    }

    public void insertNode(int value){
        if(size == 0){
            root = new Node(value);
            ++size;
            return;
        }
        root = insertNode(root,value);
    }

    private Node insertNode(Node node, int value){
        if(node == null){
            node = new Node(value);
            ++size;
            return node;
        }
        if(node.value > value){
            node.left = insertNode(node.left,value);
            return node;
        }
        else if(node.value < value){
            node.right = insertNode(node.right,value);
            return node;
        }
        else{
            return node;
        }
    }

    //Case for removing a node are:
    /*
    Case 1: 0 child or 1 child
    Case 2: 2 children
     */
    public Node deleteNode(Node node,int targetValue){ //In BST,the node to delete replace is always inorder therefore node to delete -> right -> left . . . till null
        if((size == 1) && (root.value == targetValue)){
            Node temp = root;
            root = null;
            size--;
            return temp;
        }
        if(node == null){
            return node;
        }
        if(targetValue < node.value){
            node.left = deleteNode(node.left,targetValue);
            return node;
        }
        else if(targetValue > node.value){
            node.right = deleteNode(node.right,targetValue);
            return node;
        }
        else{
            if((node.left == null) && (node.right == null)){
                node = null;
                --size;
                return node;
            }
            else if(node.right == null){ // One child on left
                --size;
                return node.left;
            }
            else if(node.left == null){
                --size;
                return node.right;
            }
            else{
                Node successor = node.right;
                while(successor.left != null){
                    successor = successor.left;
                }
                node.value = successor.value;
                node.right = deleteNode(node.right, successor.value);
                return node;
            }
        }
    }

    public void displayTree(){
        inOrder(root);
        System.out.println();
    }

    private void inOrder(Node node){
        if(node == null)
            return;
        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }


    static class Node{
        Node left;
        Node right;
        int value;

        public Node(int someValue){
            value = someValue;
        }
    }

    public static void main(String[] args) {
        MyBinarySearchTree bst = new MyBinarySearchTree(new Node(5));
        bst.insertNode(3);
        bst.insertNode(8);
        bst.insertNode(1);
        bst.insertNode(4);
        bst.insertNode(6);
        bst.insertNode(9);

    /*
          5
         / \
        3   8
       / \ / \
      1  4 6  9
    */

        System.out.println("=== Initial tree (1 3 4 5 6 8 9) ===");
        bst.displayTree();

        System.out.println("=== Delete leaf 1 ===");
        bst.root = bst.deleteNode(bst.root, 1);
        bst.displayTree();

        System.out.println("=== Delete 3 (자식 4만 남음) ===");
        bst.root = bst.deleteNode(bst.root, 3);
        bst.displayTree();

        System.out.println("=== Delete 8 (successor 9로 대체) ===");
        bst.root = bst.deleteNode(bst.root, 8);
        bst.displayTree();

        System.out.println("=== Delete root 5 (successor 6으로 대체) ===");
        bst.root = bst.deleteNode(bst.root, 5);
        bst.displayTree();

        System.out.println("=== Delete 99 (변화없음) ===");
        bst.root = bst.deleteNode(bst.root, 99);
        bst.displayTree();
    }
}
