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

import java.util.Queue;

public class MyBinaryTree {
    Node root;

    public MyBinaryTree(Node root){
        this.root = root;
    }

    public void insertNode(){
        MyQueueLink container = new MyQueueLink();

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
}
