public class MyQueue {
    int arr[];
    private int topOfStack; //index;
    private int beginning;

    public MyQueue(int size) {
        this.arr = new int[size];
        this.topOfStack = -1;
        this.beginning = -1;
        System.out.println("Queue created succesfully.");
    }

    public boolean isEmpty() {
        if (this.beginning==-1||this.beginning==arr.length) {

            return true;
        }
        return false;
    }

    public boolean isFull() {
        if (topOfStack == arr.length - 1) {
            return true;
        } else {
            return false;
        }
    }

    public void enQueue(int value) {
        if (isEmpty()) {
            beginning = 0;
            topOfStack++;
            this.arr[topOfStack] = value;

        } else if (isFull()) {
            System.out.println("Queue full.");
        } else {
            topOfStack++;
            this.arr[topOfStack] = value;
        }
    }

    public int deQueue() {
        if (isEmpty()) {
            System.out.println("Queue empty.");
            return -1;
        } else {
            int result = this.arr[beginning];
            beginning++;
            if (beginning > topOfStack) {
                topOfStack = beginning = -1;
            }
            return result;
        }
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        } else {
            return this.arr[beginning];
        }
    }

    public void deleteQueue() {
        this.arr = null;
        System.out.println("Queue successfully deleted.");
    }
}
