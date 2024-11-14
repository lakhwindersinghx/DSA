package TreeWRecursion;

public class BSTmain {
    public static void main(String[] args) {
        BST bst=new BST();
        int[] arr = {1, 2, 2, 3, 4, 4, 3};
        bst.populate(arr);
        bst.display();
    }
}
