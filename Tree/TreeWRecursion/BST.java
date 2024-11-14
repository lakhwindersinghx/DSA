package TreeWRecursion;

public class BST {
    class Node {
        Node left;
        Node right;
        int value;
        int height;

        Node(int value) {
            this.value = value;
            this.height = 0;
        }
    }

    private Node root;

    public int getHeight(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    public boolean isEmpty() {
        if (root == null) {
            return true;
        }
        return false;
    }

    public void populate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            insert(nums[i]);
        }
    }

    public void insert(int value) {
        root = insert(root, value);
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

        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        return (node);

    }

    public void display() {
        display(root);
    }

    private void display(Node node) {
        if (node == null) {
            return;
        }
        System.out.println("Node value: " + node.value);

        if (node.left != null) {
            System.out.println("Left child of " + node.value + ": " + node.left.value);
        }
        if (node.right != null) {
            System.out.println("Right child of " + node.value + ": " + node.right.value);
        }

        display(node.left);
        display(node.right);
    }

}

