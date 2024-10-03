public class LinkedListMain {
    public static void main(String[] args) {
        LinkedListClass ll = new LinkedListClass();
        Questions ex=new Questions();

        // Inserting nodes into the linked list
        ll.insertNode(1);
        ll.insertNode(2);
        ll.insertNode(3);
        ll.insertNode(4);
        ll.insertNode(5);
        ll.insertNode(6);
        ll.createLoop(3);  // Loop starts at node with value 4
        ex.xxx(ll);

    }
}
