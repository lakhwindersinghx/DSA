package TreeWRecursion.ST;

public class ST {
    private class Node {
        int startInterval;
        int endInterval;
        int data;
        Node left;
        Node right;

        Node(int startInterval, int endInterval) {
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }
    }

    private Node root;

    public ST(int[] nums) {
        this.root = constructTree(nums, 0, nums.length - 1);
    }


    public Node constructTree(int[] arr, int startInterval, int endInterval) {
        if (startInterval == endInterval) { //this means at this point tree is empty
            Node startNode = new Node(startInterval, endInterval);
            startNode.data = arr[startInterval];
            return startNode;
        }
        Node newNode = new Node(startInterval, endInterval);

        int mid = (startInterval + endInterval) / 2;

        newNode.left = constructTree(arr, startInterval, mid);
        newNode.right = constructTree(arr, mid + 1, endInterval);

        newNode.data = newNode.left.data + newNode.right.data;

        return newNode;
    }

    public void display() {
        display2(this.root, "", true);
    }

    private void display(Node node) {
        String str = "";

        if (node.left != null) {
            str = str + "Interval=[" + node.left.startInterval + "-" + node.left.endInterval + "] and data: " + node.left.data + " => ";
        } else {
            str = str + "No left child";
        }

        str = str + "Interval=[" + node.startInterval + "-" + node.endInterval + "] and data: " + node.data + " <= ";

        if (node.right != null) {
            str = str + "Interval=[" + node.right.startInterval + "-" + node.right.endInterval + "] and data: " + node.right.data;
        } else {
            str = str + "No right child";
        }
        System.out.println(str + '\n');
        if (node.left != null) {
            display(node.left);
        }

        if (node.right != null) {
            display(node.right);
        }
    }

    private void display2(Node node, String indent, boolean isLast) {
        if (node != null) {
            // Print the current node with appropriate formatting
            System.out.print(indent);
            if (isLast) {
                System.out.print("└──");
                indent += "   ";
            } else {
                System.out.print("├──");
                indent += "|  ";
            }
            System.out.println("[" + node.startInterval + "-" + node.endInterval + "] (Sum: " + node.data + ")");

            // Recursively print left and right children
            display2(node.left, indent, false);
            display2(node.right, indent, true);
        }
    }
    public int query(int qsi, int qei) {
        return query(this.root, qsi, qei);
    }

    private int query(Node node, int qsi, int qei) {
        //first case: query lies within interval
        if (qsi <= node.startInterval && qei >= node.endInterval) {
            return node.data;
        }
        //2nd case: query totally outside interval
        else if (qei < node.startInterval || qsi > node.endInterval) {
            return 0; // no contribution
        } else {
            //3rd case: left and right combine
            return this.query(node.left, qsi, qei) + this.query(node.right, qsi, qei);
        }
    }

    public void update(int index, int value) {
        update(this.root, index, value);
    }

    private int update(Node node, int index, int value) {
        if (index >= node.startInterval && index <= node.endInterval) {
            if (index == node.startInterval && index == node.endInterval) {
                return node.data = value;
            }
        } else {
            int leftAns = update(node.left, index, value);
            int rightAns = update(node.right, index, value);
            node.data = leftAns + rightAns;
            return node.data;
        }
        return node.data;
    }

}

