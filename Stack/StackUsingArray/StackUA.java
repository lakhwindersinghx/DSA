package StackUsingArray;

public class StackUA {
    int arr[];
    int topOfStack;

    StackUA(int size) {
        this.arr = new int[size];
        this.topOfStack = -1;
        System.out.println("Stack has been created with a size of: " + size);
    }


    public boolean isEmpty() {
        if (topOfStack == -1) {
            System.out.println("Stack is empty");
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if (topOfStack == this.arr.length - 1) {
            System.out.println("Stack is full.");
            return true;
        }
        return false;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack is full.");
        } else {
            topOfStack++;
            this.arr[topOfStack] = value;
        }
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
        } else {
            return this.arr[topOfStack];
        }
        return -1;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return -1;
        }
        int topStack = this.arr[topOfStack];
        topOfStack--;
        return topStack;
    }

    public boolean deleteStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return false;
        } else {
            this.arr = null;
            System.out.println("Successfully deleted.");
            return true;
        }
    }

}
