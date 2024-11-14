package TreeWRecursion;

import com.sun.source.tree.Tree;

import java.util.Scanner;

public class TreeR {
    public class Nodex {
        Nodex left;
        Nodex right;
        int value;

        Nodex(int value) {
            this.value = value;
        }
    }

    private Nodex root;

    public void populate(Scanner scanner) {
        System.out.println("Enter value of root: ");
        int value = scanner.nextInt();
        root = new Nodex(value);
        root.value = value;
        populate(scanner, root);
    }

    private void populate(Scanner scanner, Nodex Nodex) {
        System.out.println("Want to enter in left of Nodex? ");
        boolean left = scanner.nextBoolean();
        if (left) {
            System.out.println("Enter value for left of Nodex: ");
            int value = scanner.nextInt();
            Nodex.left = new Nodex(value);
            populate(scanner, Nodex);
        }
        System.out.println("Want to enter in right of Nodex? ");
        boolean answer = scanner.nextBoolean();
        if (answer) {
            System.out.println("Enter value for right of Nodex: ");
            int rightNodex = scanner.nextInt();
            Nodex.right = new Nodex(rightNodex);
            populate(scanner, Nodex);
        }
    }

    public void display() {
        display(root, " ");
    }

    private void display(Nodex Nodex, String indent) {
        System.out.println(indent + Nodex.value);
        display(Nodex.left, indent + "\t");
        display(Nodex.right, indent + "\t");
    }
}