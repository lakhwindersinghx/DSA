public class MyCircularQueue {
    private int arr[];
    int beginningOfQueue;
    int topOfQueue; //index

    public MyCircularQueue(int size) {
        this.arr = new int[size];
        this.beginningOfQueue = -1;
        this.topOfQueue = -1;
    }

    public void enque(int value) {
        if (isFull()) {
            System.out.println("Queue is full");
        } else if (isEmpty()) {
            this.beginningOfQueue = 0;
            this.topOfQueue++;
            this.arr[this.topOfQueue] = value;
        } else {
            if (this.topOfQueue + 1 == this.arr.length) {
                this.topOfQueue = 0;
            } else {
                topOfQueue++;
            }
            this.arr[topOfQueue] = value;

        }
    }

    public boolean isFull() {
        if (this.topOfQueue + 1 == this.beginningOfQueue) {
            return true;
        } else if (beginningOfQueue == 0 && this.topOfQueue + 1 == this.arr.length) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isEmpty() {
        if (beginningOfQueue == -1 || topOfQueue == -1) {
            return true;
        }
        return false;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        } else {
            return this.arr[beginningOfQueue];
        }
    }

    public void deQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
        } else if (this.topOfQueue == this.beginningOfQueue) { //only one elemnt
            this.topOfQueue = this.beginningOfQueue = -1;
        } else if (this.beginningOfQueue + 1 == this.arr.length) {
            this.beginningOfQueue = 0;
        }else {
            this.beginningOfQueue++;
        }
    }

    public void delete() {
        this.arr = null;
        System.out.println("successfully deleted");
    }
}
