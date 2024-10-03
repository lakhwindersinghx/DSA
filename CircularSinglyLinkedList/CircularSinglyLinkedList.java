public class CircularSinglyLinkedList {
    public Node head;
    public Node tail;
    public int size;

    public Node createCircularSinglyLinkedList(int nodeValue) {
        head = new Node(); //initialise
        Node node = new Node(); //empty object
        node.value = nodeValue;
        node.next = node; //points to itself because circular
        head = node;
        tail = node;
        size = 1;
        return head;
    }

    public void insertIntoList(int value, int location) {
        Node newNode = new Node();
        newNode.value = value;
        Node currentNode = head;
        if (location == 0) {
            newNode.next = head;
            head = newNode;
            tail.next = newNode;
        } else if (location >= size) {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        } else {
            for (int i = 0; i < location - 1; i++) {
                currentNode = currentNode.next;
            }
            newNode.next = currentNode.next;
            currentNode.next = newNode;
        }
        size++;
    }

    public void traverse() {
        if (head != null) {

            Node currentNode = head;
            for (int i = 0; i < size; i++) {
                System.out.print(currentNode.value);
                if (i != size - 1) {
                    System.out.print("->");
                }
                currentNode = currentNode.next;
            }
            System.out.println();
        } else {
            System.out.println("List doesn't exist");
        }
    }

    public boolean searchInTheList(int number) {
        Node currentNode = head;
        if (head != null) {
            for (int i = 0; i < size; i++) {
                if (currentNode.value == number) {
                    return true;
                }
                currentNode = currentNode.next;
            }
        }
        System.out.println("Number doesn't exist in the list.");
        return false;
    }

    public Node deleteNode(int location) {
        if (head == null) {
            System.out.println("List doesn't exist");
            return null; // Return immediately if the list doesn't exist
        }

        Node poppedNode = null;

        // If deleting the first node
        if (location == 0) {
            poppedNode = head;
            head = head.next;
            tail.next = head;
            size--;

            if (size == 0) { // If only one element was present then after size-- size would become 0 and hence
                //we gotta set head and tail to null.
                head = null;
                tail = null;
            }
        } else if (location >= size) {
            // Deleting the last node
            Node currentNode = head;
            for (int i = 0; i < size - 2; i++) {
                currentNode = currentNode.next;
            }
            poppedNode = tail;
            tail = currentNode;
            tail.next = head;
            size--;

            if (size == 0) {
                tail = null;
                head = null;
            }
        } else {
            // Deleting from the middle
            Node currentNode = head;
            for (int i = 0; i < location - 1; i++) {
                currentNode = currentNode.next;
            }
            poppedNode = currentNode.next;
            currentNode.next = currentNode.next.next;
            size--;

            // Update tail if the deleted node was the last one
            if (poppedNode == tail) {
                tail = currentNode;
            }
        }
        return poppedNode;
    }

    public boolean deleteList() {
        if (head == null) {
            System.out.println("List doesn't exist");
        } else {
            head = null;
            tail.next = null;
            tail = null;
            System.out.println("List has been sexfully deleted");
            return true;
        }
        return false;
    }

}


