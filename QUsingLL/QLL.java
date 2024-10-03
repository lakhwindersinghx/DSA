public class QLL {
    Node head;
    Node tail;
    int size;

    public void createQueue(int value) {
        head = new Node();
        Node newNode = new Node();
        newNode.value = value;
        newNode.next = null;
        head = newNode;
        tail = newNode;
        size = 1;
    }

    public void enQueue(int value) {
        Node newNode = new Node();
        newNode.value = value;
        if (head == null) {
            createQueue(value);
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
            size++;
        }
    }

    public void deQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            head = head.next; // Move head to the next node
            size--;

            if (size == 0) { // If the queue becomes empty after dequeue
                tail = null;  // Set tail to null as well
            }
        }
    }


    public int peek() {
        if (head == null) {
            System.out.println("Queue is empty.");
            return -1;
        } else {
            return this.tail.value;
        }
    }

    public boolean isEmpty() {
        if (head == null || size == 0) {
            return true;
        }
        return false;
    }
}
