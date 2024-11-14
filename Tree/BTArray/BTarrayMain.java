package BTArray;

public class BTarrayMain {
    public static void main(String[] args) {


        BTarray bta = new BTarray(9);
        bta.insertNode("N1");
        bta.insertNode("N2");
        bta.insertNode("N3");
        bta.insertNode("N4");
        bta.insertNode("N5");
        bta.insertNode("N6");
        bta.insertNode("N7");
        bta.insertNode("N8");
        bta.insertNode("N9");


        bta.preOrderTraversal(1);

    }

}