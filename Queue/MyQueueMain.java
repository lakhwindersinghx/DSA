public class MyQueueMain {
    public static void main(String[] args) {
        MyQueue mq=new MyQueue(6);
        mq.enQueue(5);
        mq.enQueue(6);
        System.out.println(mq.peek());
        mq.deQueue();
        mq.deleteQueue();
    }
}
