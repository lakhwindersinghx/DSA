public class CQMain {
    public static void main(String[] args) {
        MyCircularQueue cq = new MyCircularQueue(3);
        cq.enque(5);
        cq.enque(4);
        cq.enque(3);

        System.out.println(cq.isFull());
        System.out.println(cq.peek());
        cq.deQueue();
        System.out.println(cq.peek());
        cq.deQueue();
        System.out.println(cq.peek());
    }
}
