package StackUsingLL;

public class StackULLMain {
    public static void main(String[] args) {
        StackULL sull = new StackULL();
        sull.isEmpty();
        sull.push(1);
        sull.push(2);
        System.out.println(sull.peek());
        sull.pop();
        System.out.println(sull.peek());
        sull.deleteStack();


    }
}
