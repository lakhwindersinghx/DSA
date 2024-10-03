import java.nio.file.Paths;

public class LinkedListClass {
    Node head;
    Node tail;
    int size;

    public Node createLinkedList(int nodeValue) {
        this.head = new Node();
        Node newNode = new Node();
        newNode.value = nodeValue;
        newNode.next = null;
        this.head = newNode;
        this.tail = newNode;
        this.tail.next = null;
        size = 1;
        return head;
    }

    public void insertNode(int value) {
        Node newNode = new Node();
        newNode.value = value;
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void insertIntoList(int value, int location) {
        Node newNode = new Node();
        newNode.value = value;
        if (this.head == null) {
            createLinkedList(value);
            return;
        } else if (location == 0) {

            newNode.next = head;
            this.head = newNode;
            size++;
            return;
        } else if (location >= size) {
            this.tail.next = newNode;
            newNode.next = null;
            this.tail = newNode;
            size++;
            return;
        } else {
            Node tempNode = this.head;
            for (int i = 0; i < location - 1; i++) {
                tempNode = tempNode.next;
            }
            newNode.next = tempNode.next;
            tempNode.next = newNode;
            size++;
            return;
        }
    }

    public void traverse() {
        if (this.head == null) {
            System.out.println("List doesn't exist");
            return;
        }
        Node tempNode = this.head;
        for (int i = 0; i < size; i++) {
            if (tempNode == null) {
                break;
            }
            System.out.print(tempNode.value);
            if (i != size - 1) {
                System.out.print("->");
            }
            tempNode = tempNode.next;
        }
        System.out.println();
    }

    public Node searchInList(int value) {
        if (this.head == null) {
            System.out.println("List doesn't exist");
            return null;
        }
        Node tempNod = this.head;
        for (int i = 0; i < size - 1; i++) {
            if (tempNod.value == value) {
                System.out.println(value + " Found at index: " + i);
                return tempNod;
            }
            tempNod = tempNod.next;

        }
        System.out.println("Value doesn't exist in the list");
        return null;
    }

    public void deleteInList(int location) {
        Node tempNode = this.head;
        if (head == null) {
            System.out.println("List doesn't exist.");
            return;
        } else if (location == 0) {
            if (size == 1) {
                this.head = null;
                this.tail = null;
                size--;
                return;
            } else {
                this.head = this.head.next;
                size--;
                return;
            }
        } else if (location >= size) {
            if (size == 1) {
                this.tail = null;
                this.head = null;
                size--;
            } else {
                for (int i = 0; i < size - 1; i++) {
                    tempNode = tempNode.next;
                }
                tempNode.next = null;
                this.tail = tempNode;
                size--;
                return;
            }
        } else {
            for (int i = 0; i < location - 1; i++) {
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
            size--;
            return;
        }
    }

    public void createLoop(int position) {
        if (head == null) return;

        Node loopNode = null;
        Node current = head;
        int count = 0;

        // Traverse the list to find the node at the given position and also reach the last node
        while (current.next != null) {
            if (count == position) {
                loopNode = current;  // Store the node at the position where the loop should start
            }
            current = current.next;
            count++;
        }
        // Connect the last node's next to the node at 'position'
        current.next = loopNode;
    }


    public void deleteList() {
        this.head.next = null;
        this.head = null;
        System.out.println("List completely destroyed.");
    }
}




