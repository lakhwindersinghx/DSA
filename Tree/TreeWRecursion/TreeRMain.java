package TreeWRecursion;

import java.util.Scanner;

public class TreeRMain {
    public static void main(String[] args) {


        TreeR tr = new TreeR();
        Scanner scanner=new Scanner(System.in);
        tr.populate(scanner);
        tr.display();
    }
}