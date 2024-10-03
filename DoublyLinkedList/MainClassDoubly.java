public class MainClassDoubly {
    public static void main(String[] args) {
        DoublyLinkedList dLL=new DoublyLinkedList();
        dLL.insertIntoList(1,44);
        dLL.insertIntoList(2,1);
//        dLL.insertIntoList(3,2);
//        dLL.insertIntoList(4,3);
        dLL.traverse();
       dLL.deleteList();
       dLL.traverse();

    }
}
