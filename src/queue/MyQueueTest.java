package queue;

public class MyQueueTest {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue(5);
        myQueue.addInQueue(1);
        myQueue.addInQueue(2);
        myQueue.addInQueue(3);
        myQueue.addInQueue(4);
        myQueue.addInQueue(4);
        myQueue.addInQueue(4);
        myQueue.addInQueue(4);

        System.out.println(myQueue.getFromQueue());
        System.out.println(myQueue.getFromQueue());
        System.out.println(myQueue.getFromQueue());
        myQueue.showQueue();
        System.out.println();
        System.out.println(myQueue.toString());
    }
}
