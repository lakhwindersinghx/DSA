public class CDLL {
    DoublyCNode head;
    DoublyCNode tail;
    int size;

    public DoublyCNode createCDLL(int nodevalue) {
        head = new DoublyCNode();
        DoublyCNode newNode = new DoublyCNode();
        newNode.value = nodevalue;
        this.head = newNode;
        this.tail = newNode;
        newNode.next = newNode;
        newNode.prev = newNode;
        size = 1;
        return head;
    }

    public void insertIntoCDLL(int value, int location) {
        DoublyCNode newNode = new DoublyCNode();
        newNode.value = value; // Set the value of the new node

        if (size == 0) {
            // If the list is empty, create it
            createCDLL(value);
            return;
        } else if (location == 0) {
            // Insert at the beginning of the list
            newNode.next = this.head;
            newNode.prev = this.tail;
            this.head.prev = newNode;
            this.head = newNode; // Update head to the new node
            this.tail.next = newNode; // Maintain circularity
        } else if (location >= size) {
            // Insert at the end of the list
            newNode.next = this.head;
            newNode.prev = this.tail;
            this.tail.next = newNode; // Link the current tail to the new node
            this.head.prev = newNode; // Maintain circularity
            this.tail = newNode; // Update tail to the new node
        } else {
            // Insert at a specific location in the middle
            DoublyCNode tempNode = this.head;
            for (int i = 0; i < location - 1; i++) {
                tempNode = tempNode.next; // Traverse to the node before the insertion point
            }
            newNode.next = tempNode.next;
            newNode.prev = tempNode;
            tempNode.next.prev = newNode;
            tempNode.next = newNode;
        }
        size++; // Increase the size of the list
    }

    public void traverse() {
        if (size == 0) {
            System.out.println("List is empty/list doesn't exist");
        } else {
            DoublyCNode tempNode = this.head;
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.value);
                if (i != size - 1) {
                    System.out.print("->");
                }
                tempNode = tempNode.next;
            }
            System.out.println();
        }
    }

    public void reverseTraverse() {
        DoublyCNode tempNode = this.tail;
        for (int i = 0; i < size; i++) {
            System.out.print(tempNode.value);
            if (i != size - 1) {
                System.out.print("<-");
            }
            tempNode = tempNode.prev;
        }
        System.out.println();
    }

    public DoublyCNode searchInList(int value) {
        DoublyCNode tempNode = this.head;
        if (size == 0) {
            System.out.println("LIST DOESNT EXIST.");
            return null;
        } else {

            for (int i = 0; i < size; i++) {
                if (tempNode.value == value) {
                    System.out.println("Node found at " + i);
                    return tempNode;
                }
                tempNode = tempNode.next;
            }

        }
        System.out.println(value + " Doesn't exist in the list.");
        return null;
    }

    public void deleteNode(int location) {
        if (head == null) {
            System.out.println("List doesnt exist");
            return;
        } else if (location == 0) {
            if (size == 1) {  // If there's only one node in the list
                head = null;
                tail = null;
            } else {
                this.tail.next = this.head.next;
                this.head.next.prev = this.tail;
                this.head = this.head.next;
            }
            size--;
        } else if (location >= size) {
            if (size == 1) {
                head = null;
                tail = null;
            } else {
                this.head.prev = this.tail.prev;
                this.tail.prev.next = this.head;
                this.tail = this.tail.prev;
            }
            size--;
        } else {
            DoublyCNode tempNode = this.head;
            for (int i = 0; i < location - 1; i++) {
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
            tempNode.next.prev = tempNode;
            size--;
        }
    }

    public void deleteCDLL() {
        if (size == 0) {
            System.out.println("List doesn't exist");
        } else {
            DoublyCNode tempNode = this.head;
            for (int i = 0; i < size; i++) {
                tempNode.prev = null;
                tempNode = tempNode.next;
            }
            this.head = null;
            this.tail = null;
        }
        System.out.println("List succesfully deleted.");
        size = 0;
    }
}

