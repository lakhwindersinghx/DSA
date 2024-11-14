package MyBinaryTree;

import java.lang.annotation.Target;
import java.util.LinkedList;
import java.util.Queue;

public class MyBinaryTree {
    BinaryNode root;

    public MyBinaryTree() {
        this.root = null;
    }

    public void preOrder(BinaryNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");

        preOrder(node.leftNode);
        preOrder(node.rightNode);
    }

    public void inOrder(BinaryNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.leftNode);
        System.out.print(node.value + " ");
        inOrder(node.rightNode);
    }

    public void postTraversal(BinaryNode node) {
        if (node == null) {
            return;
        }
        postTraversal(node.leftNode);
        postTraversal(node.rightNode);
        System.out.print(node.value + " ");
    }

    public void levelOrderTraversal() {
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);

        while (!(queue.isEmpty())) {
            BinaryNode presentNode = queue.remove();
            System.out.print(presentNode.value + " ");

            if (presentNode.leftNode != null) {
                queue.add(presentNode.leftNode);
            }
            if (presentNode.rightNode != null) {
                queue.add(presentNode.rightNode);
            }
        }
        System.out.println();
    }
    public void search(String target) {
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);

        while (!(queue.isEmpty())) {
            BinaryNode presentNode = queue.remove();
            if (presentNode.value == target) {
                System.out.print(presentNode.value + " Found in the Tree");
                return;
            }
            if (presentNode.leftNode != null) {
                queue.add(presentNode.leftNode);
            }
            if (presentNode.rightNode != null) {
                queue.add(presentNode.rightNode);
            }
        }
        System.out.println(target + " not found");
    }

    public void insertNode(String value) {
        BinaryNode newNode = new BinaryNode();
        newNode.value = value;
        if (root == null) {
            root = newNode;
            return;
        }

        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode currentNode = queue.remove();
            if (currentNode.leftNode == null) {
                currentNode.leftNode = newNode;
                System.out.println(newNode.value + " succesfully added");
                break;
            } else if (currentNode.rightNode == null) {
                currentNode.rightNode = newNode;
                System.out.println(newNode.value + " succesfully added");
                break;
            } else {
                queue.add(currentNode.leftNode);
                queue.add(currentNode.rightNode);
            }
        }
    }

    //DELETING A NODE
    //HELPER FUNCTIONS :
    //GETDEEPESTNODE
    //FIND DEEPEST NODE
    //DELETE DEEPEST NODE, MAKE LAST SECOND NODE TO BE NEW DEEPEST NODE.
    public BinaryNode getDeepestNode() {
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);
        BinaryNode currentNode = null;
        while (!(queue.isEmpty())) {
            currentNode = queue.remove();

            if (currentNode.leftNode != null) { //last node's right node is deepest node
                queue.add(currentNode.leftNode);
            }
            if (currentNode.rightNode != null) {// current node's left node is the deepest node.
                queue.add(currentNode.rightNode);
            }
        }
        return currentNode;
    }

    public void deleteDeepestNode() {
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);
        BinaryNode previousNode, currentNode = null;
        while (!(queue.isEmpty())) {
            previousNode = currentNode;
            currentNode = queue.remove();
            if (currentNode.leftNode == null) {
                previousNode.rightNode = null;
                return;
            } else if (currentNode.rightNode == null) {
                currentNode.leftNode = null;
                return;
            }
            queue.add(currentNode.leftNode);
            queue.add(currentNode.rightNode);
        }
    }

    public void deleteNode(String value) {
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);
        BinaryNode currentNode = null;
        while (!(queue.isEmpty())) {
            currentNode = queue.remove();
            if (currentNode.value == value) {
                currentNode.value = getDeepestNode().value;
                deleteDeepestNode();
                return;
            } else {
                if (currentNode.leftNode != null) {
                    queue.add(currentNode.leftNode);
                }
                if (currentNode.rightNode != null) {
                    queue.add(currentNode.rightNode);
                }
            }
        }
        System.out.println("Value not in the Tree");
    }
}