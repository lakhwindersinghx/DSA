package TreeWRecursion;

public class AVLMain {
    public static void main(String[] args) {
        AVLTree avl = new AVLTree();
        for (int i = 0; i < 100000; i++) {
            avl.insert(i);
        }
        System.out.println(avl.height());
        avl.display();
    }

}
