public class QLLMain {
    public static void main(String[] args) {
        QLL qll=new QLL();
        qll.enQueue(5);
        qll.enQueue(6);
        qll.enQueue(7);
        System.out.println(qll.head.value);
        qll.deQueue();
        System.out.println(qll.head.value);
        qll.deQueue();
        System.out.println(qll.isEmpty());
        qll.deQueue();
    }
}
