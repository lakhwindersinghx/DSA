public class DoublyLinkedList {
    DoublyNode head;
    DoublyNode tail;
    int size;

    public DoublyNode createDoublyLinkedList(int nodeValue) {
        head = new DoublyNode();
        DoublyNode newNode = new DoublyNode();
        newNode.value = nodeValue;
        newNode.next = null;
        newNode.prev = null;
        this.head = newNode;
        this.tail = newNode;
        size = 1;
        return head;
    }

    public void insertIntoList(int nodeValue, int location) {
        DoublyNode newNode = new DoublyNode();
        newNode.value = nodeValue;
        if (head == null) {
            createDoublyLinkedList(nodeValue);
            return;
        } else if (location == 0) {
            newNode.next = head;
            newNode.prev = null;
            if (head != null) {
                head.prev = newNode;
            }
            head = newNode;
        } else if (location >= size) {
            newNode.next = null;
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        } else {
            DoublyNode currentNode = head;
            for (int i = 0; i < location - 1; i++) {
                currentNode = currentNode.next;
            }
            newNode.next = currentNode.next;
            newNode.prev = currentNode;
            currentNode.next.prev = newNode;
            currentNode.next = newNode;
        }
        size++;
    }

    public void traverse() {
        DoublyNode currentNode = head;
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        while (currentNode != null) {
            System.out.print(currentNode.value);
            if (currentNode.next != null) {
                System.out.print("->");
            }
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    public void reverseTraverse() {
        if (head == null) {
            System.out.println("DLL doesn't exist");
            return;
        }

        DoublyNode currentNode = tail;
        while (currentNode != null) {
            System.out.print(currentNode.value);
            currentNode = currentNode.prev;
            if (currentNode != null) {
                System.out.print("<-");
            }
        }
        System.out.println();
    }

    public boolean searchInList(int value) {
        DoublyNode tempNode = new DoublyNode();
        tempNode = head;
        if (head == null) {
            System.out.println("DLL doesn't exist");
            return false;
        }
        while (tempNode != null) {
            if (tempNode.value == value) {
                return true;
            }
            tempNode = tempNode.next;
        }
        return false;
    }

    public boolean deleteNode(int location) {
        if (head == null) {
            System.out.println("list doesn't exist");
            return false;
        }
        //if first element in the list
        if (location == 0) {
            if (size == 1) {// if only one element in the list
                head = null;
                tail = null;
                size--;
                System.out.println("deletion successful");
                return true;
            }
            this.head = this.head.next;
            this.head.prev = null;
            size--;
            System.out.println("DELETION SUCCESSFULLY.");
            return true;
        } else if (location >= size) {
            //if last location and more than one element in the lit
            DoublyNode tempNode = this.tail.prev;
            if (size == 1) {
                head = null;
                tail = null;
                size--;
                return true;
            } else {
                tempNode.next = null;
                tail = tempNode;
                size--;
                return true;
            }
        } else {
            DoublyNode currentNode = this.head;
            for (int i = 0; i < location - 1; i++) { // one element before the target
                currentNode = currentNode.next; //traverse
            }
            currentNode.next = currentNode.next.next;
            currentNode.next.prev = currentNode;
            size--;
            System.out.println("Couldn't delete.");
            return true;
        }
    }

    public boolean deleteList() {
        DoublyNode tempNode = this.head;
        for (int i = 0; i < size; i++) {
            tempNode.prev = null;
            tempNode = tempNode.next;
        }
        head = null;
        tail = null;
        System.out.println("Deletion succesful");
        return true;
    }
}

