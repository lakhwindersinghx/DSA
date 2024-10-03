import javax.sound.sampled.Line;
import java.util.HashSet;

public class Questions {
    public void deleteDups(LinkedListClass LL) {
        HashSet<Integer> finalSet = new HashSet();
        Node currentNode = LL.head;
        Node prevNode = null;
        while (currentNode != null) {
            if (!finalSet.contains(currentNode.value)) {
                finalSet.add(currentNode.value);
                prevNode = currentNode;
            } else {
                prevNode.next = currentNode.next;
                LL.size--;
            }
            currentNode = currentNode.next;
        }
    }

    public void nTH(LinkedListClass LL, int location) {
        Node pointerOne = LL.head;
        Node pointerTwo = LL.head;

        for (int i = 0; i < location; i++) {
            pointerOne = pointerOne.next;
        }

        while (pointerOne != null) {
            pointerOne = pointerOne.next;
            pointerTwo = pointerTwo.next;
        }
        System.out.println(pointerTwo.value);
    }

    public LinkedListClass partition(LinkedListClass LL, int value) {
        Node currentNode = LL.head;
        LL.tail = LL.head;
        while (currentNode != null) {
            Node next = currentNode.next;
            if (currentNode.value < value) {
                currentNode.next = LL.head;
                LL.head = currentNode;
            } else {
                LL.tail.next = currentNode;
                LL.tail = currentNode;
            }
            currentNode = next;
        }
        LL.tail.next = null;
        return LL;
    }

    public LinkedListClass sumLists(LinkedListClass llOne, LinkedListClass llTwo) {
        Node l1 = llOne.head;
        Node l2 = llTwo.head;
        LinkedListClass llThree = new LinkedListClass();
        int carry = 0;

        while (l1 != null || l2 != null || carry > 0) {  // Add 'carry > 0' to handle leftover carry
            int result = carry;
            if (l1 != null) {
                result += l1.value;
                l1 = l1.next;
            }
            if (l2 != null) {
                result += l2.value;
                l2 = l2.next;
            }
            llThree.insertNode(result % 10);  // Insert only the last digit //modulus is used to get last digit of a double digit number
            carry = result / 10;  // Carry will be result / 10 // division "/" will give us quotient which is used as carry over to next sum
        }
        return llThree;
    }

    public void addSameNode(LinkedListClass llA, LinkedListClass llB, int nodeValue) {
        Node newNode = new Node();
        newNode.value = nodeValue;
        llA.tail.next = newNode;
        llA.tail = newNode;
        llB.tail.next = newNode;
        llB.tail = newNode;

    }

    public Node findIntersection(LinkedListClass llA, LinkedListClass llB) {
        //FIRE BOY WATER GIRL PROBLEM AS WELL ITS CALLED
        Node n1 = llA.head;
        Node n2 = llB.head;
        while (n1 != n2) {
            if (n1 == null) {
                n1 = llB.head;
            } else {
                n1 = n1.next;
            }
            if (n2 == null) {
                n2 = llA.head;
            } else {
                n2 = n2.next;
            }
        }
        return n1;
    }

    public Node findIntersection2(LinkedListClass llA, LinkedListClass llB) {
        int lengthListA = llA.size;
        int lengthListB = llB.size;
        Node n1 = llA.head;
        Node n2 = llB.head;

        while (lengthListA > lengthListB) {
            lengthListA--;
            n1 = n1.next;
        }
        while (lengthListB > lengthListA) {
            lengthListB--;
            n2 = n2.next;
        }

        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }

        return n1;
    }


    public LinkedListClass sumListsx(LinkedListClass l1, LinkedListClass l2) {
        LinkedListClass l3 = new LinkedListClass();
        Node n1 = l1.head;
        Node n2 = l2.head;
        int carry = 0;

        while (n1 != null || n2 != null) {
            int result = carry;
            if (n1 != null) {
                result += n1.value;
                n1 = n1.next;
            }
            if (n2 != null) {
                result += n2.value;
                n2 = n2.next;
            }
            l3.insertNode(result % 10);
            carry = result / 10;
        }
        return l3;

    }


    public void xxx(LinkedListClass ll) {
        Node n1 = ll.head;
        Node n2 = ll.head.next;

        int counter = 0;

        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next.next;
        }

        Node n3 = n1;
        n3=n3.next;
        counter++;
        while (n3 != n1) {
            n3 = n3.next;
            counter++;
        }
        System.out.println("Length: " + counter);
    }

}




