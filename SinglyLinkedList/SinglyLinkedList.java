public class SinglyLinkedList {
    public Node head;
    public Node tail;
    public int size;

    public Node CreateSinglyLinkedList(int nodeValue) {
        head = new Node();
        Node node = new Node();
        node.next = null;
        node.value = nodeValue;
        head = node;
        tail = node;
        this.size = 1;
        return head;
    }

    public void insertInLinkedList(int nodeValue, int location) {
        Node node = new Node();
        node.value = nodeValue;
        if (head == null) { //no linked list
            this.CreateSinglyLinkedList(nodeValue);
        } else if (location == 0) {
            node.next = head;
            head = node;

        } else if (location >= size) {
            node.next = null;
            tail.next = node;
            tail = node;
        } else {
            Node tempNode = head; // Loop from head
            int index = 0;
            while (index < location - 1) {
                tempNode = tempNode.next;
                index++;
            }
            Node nextNode = tempNode.next;
            tempNode.next = node;
            node.next = nextNode;
        }
        size++;
    }


    public void traverseSinglyLinkedList() {
        if (head == null) {
            System.out.println("LIST DOESN'T EXIST.");
        } else {
            Node tempnode = head;
            for (int i = 0; i < size; i++) {
                if (tempnode == null) {
                    break; // Exit if tempnode becomes null before reaching size
                }
                System.out.print(tempnode.value);
                if (tempnode.next != null) {  // Print arrow if not the last node
                    System.out.print("->");
                }
                tempnode = tempnode.next;
            }
        }
        System.out.println();  // Move to the next line after the list is printed
    }

    public boolean searchSinglyLinkedList(int number) {
        if (head == null) {
            System.out.println("LIST DOESN'T EXIST.");
        } else {
            Node tempnode = head;
            for (int i = 0; i < size; i++) {
                if (tempnode == null) {
                    break; // Exit if tempnode becomes null before reaching size
                }
                if (tempnode.value == number) {
                    System.out.println("Found at: " + i);
                    return true;
                }
                tempnode = tempnode.next;
            }
        }
        return false;
    }

    public void deleteOfNode(int location) {
        //IF WE'RE DELETING HEAD
        //first check if list exists or not
        if (head == null) {
            System.out.println("DOESNT EXIST");
        }
        //if more than one element in list
        if (location == 0) {
            head.next = null;
            size--;
            //if only one
            if (size == 0) {
                tail = null;
                size--;
            }
        } else if (location >= size) {
            //deleting from last
            Node tempnode = head;
            for (int i = 0; i < size - 1; i++) { //traversal
                tempnode = tempnode.next;
            }
            //if only one element in the list
            if (tempnode == head) {
                tail = head = null;
                size--;
                return;
            }
            //if more than one element
            tempnode.next = null;

            tail = tempnode;

            size--;
        } else {
            Node tempnode = head;
            for (int i = 0; i < location - 1; i++) {
                tempnode = tempnode.next;
            }
            tempnode.next = tempnode.next.next;
            size--;
        }
    }

    public void deleteAll() {
        if (head == null) {
            System.out.println("doesnt exist");
        }
        head = tail = null;
    }
}

