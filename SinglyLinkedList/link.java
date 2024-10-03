public class link {
    Node head;
    Node tail;
    int size;

    public void CreateLinkList(int nodeValue) {
        Node node = new Node();
        node.value = nodeValue;
        node.next = null;
        head = tail = node;
        size = 1;
    }

    public void push(int number) {
        if (head == null) {
            CreateLinkList(number);
            return;
        }
        Node newNode = new Node();
        newNode.value = number;
        newNode.next = null;

        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public Node pop() {
        if (size == 0) {
            System.out.println("SLL doesn't exist");
            return null;
        }

        Node poppedNode;

        if (head == tail) {
            poppedNode = head;
            head = tail = null;
        } else {
            Node currentNode = head;
            while (currentNode.next != tail) {
                currentNode = currentNode.next;
            }
            poppedNode = tail;
            tail = currentNode;
            tail.next = null;
        }
        size--;
        return poppedNode;
    }

    public boolean insert(int data, int index) {
        if (index < 0 || index > size) {
            return false;
        }
        if (index == 0) {
            Node newNode = new Node();
            newNode.value = data;
            newNode.next = head;
            head = newNode;
            size++;
            return true;
        }

        Node currentNode = head;
        for (int i = 0; i < index - 1; i++) {
            currentNode = currentNode.next;
        }

        Node newNode = new Node();
        newNode.value = data;
        newNode.next = currentNode.next;
        currentNode.next = newNode;

        if (newNode.next == null) {
            tail = newNode;
        }

        size++;
        return true;
    }

    public void traverse() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.value + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    public Node get(int index) {
        if (size == 0) {
            System.out.println("SLL doesn't exist");
            return null;
        }
        if (index < 0 || index >= size) {
            System.out.println("Wrong index.");
            return null;
        }

        Node currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    public String rotate(int number) {
        if (head == null || tail == null || number <= 0 || number >= size) {
            return "Invalid operation";
        }

        Node prevNode = head;
        for (int i = 0; i < number - 1; i++) {
            prevNode = prevNode.next;
        }

        tail.next = head;
        head = prevNode.next;
        tail = prevNode;
        tail.next = null;

        return "success";
    }

    public boolean set(int index, int value) {
        if (index < 0 || index >= size) {
            System.out.println("Wrong index.");
            return false;
        }

        Node currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        currentNode.value = value;
        return true;
    }

    public Node remove(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Wrong index.");
            return null;
        }
        if (index == 0) {
            Node removedNode = head;
            head = head.next;
            size--;
            if (size == 0) {
                tail = null;
            }
            return removedNode;
        }

        Node prevNode = head;
        for (int i = 0; i < index - 1; i++) {
            prevNode = prevNode.next;
        }

        Node removedNode = prevNode.next;
        prevNode.next = removedNode.next;
        size--;

        if (prevNode.next == null) {
            tail = prevNode;
        }

        return removedNode;
    }
}
