package StackUsingLL;


public class StackULL {
    private final LinkedListClass linkedList;

    public StackULL() {
        linkedList = new LinkedListClass();
        System.out.println("Stack created successfully.");
    }

    public void push(int value) {
        linkedList.insertIntoList(value, 0);
        System.out.println("Inserted " + value + " succesfully.");
    }

    public boolean isEmpty() {
        if (linkedList.head == null) {
            System.out.println("Stack is empty.");
            return true;
        }
        return false;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("List is empty.");
            return -1;
        }
        int result = linkedList.head.value;
        linkedList.deleteInList(0);
        return result;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return -1;
        } else {
            return linkedList.head.value;
        }
    }

    public void deleteStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
        } else {
            linkedList.head = null;
            System.out.println("Stack deleted successfully.");
        }
    }
}
