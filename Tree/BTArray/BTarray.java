package BTArray;

public class BTarray {
    String[] arr;
    int lastUsedIndex;

    BTarray(int size) {
        arr = new String[size + 1];
        lastUsedIndex = 0;
        System.out.println("Blank tree of size " + size + " has been created.");
    }

    public boolean isFull() {
        if (arr.length - 1 == lastUsedIndex) {
            return true;
        } else {
            return false;
        }
    }

    public void insertNode(String value) {
        if (!isFull()) {
            arr[lastUsedIndex + 1] = value;
            lastUsedIndex++;
        } else {
            System.out.println("BT is full.");
        }
    }

    public void preOrderTraversal(int index) {
        if (index > lastUsedIndex) {
            return;
        }
        System.out.print(arr[index] + " ");
        preOrderTraversal(index * 2);
        preOrderTraversal(index * 2 + 1);
    }

    public void inOrderTraversal(int index) {
        if (index > lastUsedIndex) {
            return;
        }
        preOrderTraversal(index * 2);
        System.out.print(arr[index] + " ");
        preOrderTraversal(index * 2 + 1);
    }

    public void postOrderTraversal(int index) {
        if (index > lastUsedIndex) {
            return;
        }
        preOrderTraversal(index * 2);
        preOrderTraversal(index * 2 + 1);
        System.out.print(arr[index] + " ");
    }

    public int search(String value) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == value) {
                System.out.println("Value found");
                return i;
            }
        }
        System.out.println("Not in the tree!");
        return -1;
    }

    public void deleteNode(String value) {
        int location = search(value);
        if (location == -1) {
            return;
        }
        arr[location] = arr[lastUsedIndex];
        lastUsedIndex--;
    }

    public void deleteTree() {
        this.arr = null;
    }

    
}
