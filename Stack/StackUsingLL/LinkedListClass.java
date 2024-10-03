package StackUsingLL;

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

}
