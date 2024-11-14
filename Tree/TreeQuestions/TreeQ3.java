package TreeQuestions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeQ3 {
    public static void main(String[] args) {
        TreeQ3 tq3 = new TreeQ3();

        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        tq3.populate(nums);
        Queue<Node> queue = new LinkedList<>();
        tq3.findLeaf(tq3.root);

    }

    class Node {
        Node left;
        Node right;
        Node next;
        int value;
        int height;

        Node(int value) {
            this.value = value;
            this.height = 0;
        }
    }

    private Node root;
    private int diameter;

    public int getHeight(Node node) {
        if (node == null) {
            return 0;
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
        if (nums.length == 0) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        this.root = new Node(nums[0]);
        queue.add(this.root);

        int i = 1;
        while (i < nums.length) {
            Node currentNode = queue.poll();

            // Insert left child
            if (i < nums.length) {
                currentNode.left = new Node(nums[i++]);
                queue.add(currentNode.left);
            }

            // Insert right child
            if (i < nums.length) {
                currentNode.right = new Node(nums[i++]);
                queue.add(currentNode.right);
            }
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

    public int findHeight(Node root) {
        //use DFS
        if (root == null) {
            return 0;
        }
        int hLeft = findHeight(root.left); //touches the end of left side until touches null
        int hRight = findHeight(root.right);//right side same

        return Math.max(hLeft, hRight) + 1;
    }

    public int iterativeHeight(Node node) {
        if (node == null) {
            return -1; // Return -1 to match the convention used in `getHeight()`
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        int height = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Number of nodes at the current level
            height++;

            // Process all nodes at the current level
            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();

                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
        }

        return height;
    }

    public void leftMostView(Node node) {
        if (node == null) {
            return; //
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);


        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Number of nodes at the current level

            // Process all nodes at the current level
            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();
                if (i == 0) {
                    System.out.println(currentNode.value);
                }
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
        }
    }

    public Node findDeepestNode(Node root) {
        if (root == null) {
            return null;
        }
        Node currentNode = null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!(queue.isEmpty())) {
            int levelsize = queue.size();
            for (int i = 0; i < levelsize; i++) {
                currentNode = queue.poll();

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
        }
        return currentNode;
    }

    private Node searchNode(Node node, int target) {
        if (node == null) {
            return null;
        }

        if (node.value == target) {
            System.out.println("Node: " + node + " and it's value: " + node.value);
            return node;
        }
        Node leftResult = searchNode(node.left, target);
        if (leftResult != null) {
            return leftResult; // Return immediately if found in the left subtree
        }

        // Recursively search the right subtree
        Node rightResult = searchNode(node.right, target);
        if (rightResult != null) {
            return rightResult; // Return immediately if found in the right subtree
        }

        // If not found in either subtree, return null
        return null;
    }

    public int findDiameterX(Node root) {
        findHeightX(root);
        return diameter;
    }

    public int findHeightX(Node root) {
        if (root == null) {
            return 0;
        }
        int hleft = findHeightX(root.left);
        int hright = findHeightX(root.right);

        int maxHeight = Math.max(hleft, hright) + 1;
        int dia = hleft + hright + 1;

        diameter = Math.max(dia, diameter);
        return maxHeight;
    }

    public int findDistance(int x, int y) {
        Node startingNode = searchNode(root, x);
        Node endingNode = searchNode(root, y);

        if (startingNode == null || endingNode == null) {
            return -1; // One or both of the nodes are not in the tree
        }

        Node LCA = findLCA(root, startingNode, endingNode);

        int startingDistance = findDistanceFromLCA(LCA, startingNode, 0);
        int endingDistance = findDistanceFromLCA(LCA, endingNode, 0);

        if (startingDistance == -1 || endingDistance == -1) {
            return -1; // Indicates that one of the paths was not found
        }

        return startingDistance + endingDistance;
    }


    private int findDistanceFromLCA(Node root, Node target, int distance) {
        if (root == null) {
            return -1;
        }
        if (root == target) {
            return distance;
        }
        int leftDist = findDistanceFromLCA(root.left, target, distance + 1);
        if (leftDist != -1) {
            return leftDist;
        }
        int rightDist = findDistanceFromLCA(root.right, target, distance + 1);
        return rightDist;
    }

    public Node findLCA(Node root, Node p, Node q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        Node left = findLCA(root.left, p, q);
        Node right = findLCA(root.right, p, q);
        if (left != null && right != null) {
            return root;
        } else {
            return left == null ? right : left;
        }

    }

    public Boolean ifIdentical(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return false; //empt tress
        }
        if (root1 == null || root2 == null) {
            return false; //mismatch
        }
        Queue<Node> queue1 = new LinkedList<>();
        queue1.offer(root1);
        Queue<Node> queue2 = new LinkedList<>();
        queue2.offer(root2);

        while (!(queue1.isEmpty()) && !(queue2.isEmpty())) {
            Node node1 = queue1.remove();
            Node node2 = queue2.remove();


            if (node1.value != node2.value) {
                return false; // If values don't match, return false
            }

            // Add left and right children to the respective queues
            if (node1.left != null) {
                queue1.offer(node1.left);
            }
            if (node1.right != null) {
                queue1.offer(node1.right);
            }
            if (node2.left != null) {
                queue2.offer(node2.left);
            }
            if (node2.right != null) {
                queue2.offer(node2.right);
            }

        }
        return queue1.isEmpty() && queue2.isEmpty(); //meaning they were both traversed completely hence match
    }

        public void findLeaf(Node root) {
        if (root == null) {
            return; // Tree is empty
        }
        if (root.left == null && root.right == null) {
            System.out.println("LEAF NODES: " + root.value);  // Add leaf node to the queue
        }
        findLeaf(root.left);  // Traverse left subtree
        findLeaf(root.right); // Traverse right subtree
    }

}

