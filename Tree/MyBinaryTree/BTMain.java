package MyBinaryTree;

public class BTMain {
    public static void main(String[] args) {
        MyBinaryTree bt = new MyBinaryTree();
//        BinaryNode N1 = new BinaryNode();
//        N1.value = "N1";
//        BinaryNode N2 = new BinaryNode();
//        N2.value = "N2";
//        BinaryNode N3 = new BinaryNode();
//        N3.value = "N3";
//        BinaryNode N4 = new BinaryNode();
//        N4.value = "N4";
//        BinaryNode N5 = new BinaryNode();
//        N5.value = "N5";
//        BinaryNode N6 = new BinaryNode();
//        N6.value = "N6";
//        BinaryNode N7 = new BinaryNode();
//        N7.value = "N7";
//        BinaryNode N8 = new BinaryNode();
//        N8.value = "N8";
//        BinaryNode N9 = new BinaryNode();
//        N9.value = "N9";
//        N1.leftNode = N2;
//        N1.rightNode = N3;
//        N2.leftNode = N4;
//        N2.rightNode = N5;
//        N3.leftNode = N6;
//        N3.rightNode = N7;
//        N4.leftNode = N8;
//        N4.rightNode = N9;

//        bt.root = N1;
        bt.insertNode("N1");
        bt.insertNode("N2");
        bt.insertNode("N3");
        bt.insertNode("N4");
        bt.insertNode("N5");
        bt.insertNode("N6");

        bt.deleteNode("N5");
        bt.levelOrderTraversal();
        System.out.println( bt.getDeepestNode().value);
    }
}
