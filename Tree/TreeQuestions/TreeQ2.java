package TreeQuestions;

import TreeWRecursion.BST;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeQ2 {
    public static void main(String[] args) {
        TreeQ2 tq2 = new TreeQ2();
        int[] arr = {1, 2, 2, 3, 4, 4, 3};
        tq2.populate(arr);
//        leftMost(tq2.root);
        System.out.println(tq2.findDiameter(tq2.root));


    }

    private class Node {
        private int value;
        private Node left;
        private Node right;
        private Node next;
        private int height;

        private Node(int value) {
            this.value = value;
        }
    }

    Node root;
    int diameter = 0;

    public void populate(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }
    }

    public void insert(int value) {
        this.root = insert(this.root, value);
    }

    private Node insert(Node node, int value) {
        if (node == null) {
            node = new Node(value);
            return node;
        }
        if (value < node.value) {
            node.left = insert(node.left, value);
        }
        if (value > node.value) {
            node.right = insert(node.right, value);
        }
        return node;
    }

    public Node maxVal(Node root) {
        Node maxNode = root;
        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(maxNode);
        while (!(queue.isEmpty())) {
            Node node = queue.poll();
            if (node.value > maxNode.value) {
                maxNode.value = node.value;
            }
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return maxNode;
    }

    public int getHeight(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    public Boolean symmetric(Node root) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while (!(queue.isEmpty())) {

            Node left = queue.poll();
            Node right = queue.poll();

            if (left == null && right == null) {
                continue;
            }

            if (left == null || right == null) {
                return false;
            }
            if (left.value != right.value) {
                return false;
            }
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }

    public int heightOfTree(Node root) {
        if (root == null) {
            return -1;
        }
        int hleft = heightOfTree(root.left);
        int hright = heightOfTree(root.right);

        return Math.max(hleft, hright) + 1;
    }

    public static void leftMost(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.value);
        leftMost(node.left);
    }

    public Node deepestNode(Node root) {
        if (root == null) {
            return null;
        }
        Node node = null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!(queue.isEmpty())) {
            node = queue.poll();
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return node;
    }

    public int findDiameter(Node root) {
        findHeight(root);
        return diameter;
    }

    public int findHeight(Node root) {
        if (root == null) {
            return 0;
        }
        int hleft = findHeight(root.left);
        int hright = findHeight(root.right);

        int maxHeight = Math.max(hleft, hright) + 1;
        int dia = hleft + hright + 1;

        diameter = Math.max(dia, diameter);
        return maxHeight;
    }

    public Node invertTree(Node root) {
        if (root == null) {
            return null;
        }
        Node left = invertTree(root.left);
        Node right = invertTree(root.right);

        root.left = right;
        root.right = left;
        return root;
    }
}

