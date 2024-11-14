package TreeQuestions;

import TreeWRecursion.BST;

import java.util.*;

public class TreeQ {
    public static void main(String[] args) {
        TreeQ tq = new TreeQ();
        int[] arr = {3, 9, 20, 15, 7};
        tq.populate(arr);
        System.out.println(tq.levelOrder(tq.root));
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
        } else {
            node.right = insert(node.right, value);
        }
        return node;
    }

    public void BFS() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(this.root);
        while (!(queue.isEmpty())) {
            Node node = queue.remove();
            System.out.print(node.value + "-");
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        System.out.println();
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);


        while (!(queue.isEmpty())) {
            List<Integer> values = new ArrayList<>();
            int levelsize = queue.size();
            for (int i = 0; i < levelsize; i++) {
                Node node = queue.poll();
                values.add(node.value);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(values);


        }
        return result;
    }

    public List<Double> averageOfLevels() {
        return averageOfLevels(this.root);
    }

    public List<Double> averageOfLevels(Node root) {
        List<Double> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        Double average = (double) 0;

        while (!(queue.isEmpty())) {
            int levelsize = queue.size();
            for (int i = 0; i < levelsize; i++) {
                Node node = queue.poll();

                average += node.value;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            average = average / levelsize;
            result.add(average);
        }

        return result;

    }

    public Node findSuccessor(int key) {
        return findSuccessor(this.root, key);
    }

    public Node findSuccessor(Node node, int key) {
        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!(queue.isEmpty())) {
            node = queue.poll();


            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (node.value == key) {
                break;
            }
        }

        return queue.peek();
    }

    public List<List<Integer>> zigZag() {
        return zigZag(this.root);
    }

    public List<List<Integer>> zigZag(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        boolean reverse = false; // Flag to indicate the order of adding elements at each level
        while (!queue.isEmpty()) {
            List<Integer> values = new ArrayList<>();
            int levelsize = queue.size();

            // Process all nodes at the current level
            for (int i = 0; i < levelsize; i++) {
                Node node = queue.poll();
                values.add(node.value);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            // Reverse the current level's values if needed
            if (reverse) {
                Collections.reverse(values);
            }
            result.add(values);

            // Toggle the reverse flag for the next level
            reverse = !reverse;
        }
        return result;
    }

    public List<List<Integer>> reverseLevelOrder() {
        return reverseLevelOrder(this.root);
    }

    public List<List<Integer>> reverseLevelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!(queue.isEmpty())) {
            List<Integer> values = new ArrayList<>();
            int levelsize = queue.size();
            for (int i = 0; i < levelsize; i++) {
                Node node = queue.poll();
                values.add(node.value);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(0, values);


        }
        return result;

    }

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!(queue.isEmpty())) {

            Node node = queue.poll();

            node.next = node.right;
            if (node.right == null) {
                queue.offer(null);
            }
        }
        return root;
    }
}

