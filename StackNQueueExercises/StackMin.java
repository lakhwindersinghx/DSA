public class StackMin {
    public static void main(String[] args) {
        StackMin ss = new StackMin();
        ss.push(8);
        ss.push(3);
        ss.push(6);
        ss.push(77);
        ss.push(88);
        System.out.println(ss.stackMin());  // Should print 3
    }

    private LinkedListClass ll;
    private LinkedListClass minStack;

    StackMin() {
        this.ll = new LinkedListClass();
        this.minStack = new LinkedListClass();
    }

    public void push(int value) {


        ll.insertIntoList(value, 0);
        if (minStack.head == null || value <= minStack.head.value) {
            minStack.insertIntoList(value, 0);
        }
    }


        public void pop () {
            if (ll.head == null) {
                System.out.println("Stack empty.");
            } else {
                if (ll.head.value == minStack.head.value) {
                    ll.deleteInList(0);
                    minStack.deleteInList(0);
                }
                ll.deleteInList(0);
            }
        }

        public int stackMin () {
            if (minStack.head == null) {
                System.out.println("Stack is empty.");
                return -1;
            }
            return minStack.head.value;
        }
    }
