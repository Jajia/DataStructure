package queue;

public class MyQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] queue;

    public MyQueue(int maxSize) {
        this.maxSize = maxSize;
        this.queue = new int[maxSize];
        this.front = -1;
        this.rear = -1;
    }

    public void addInQueue(int value) {
        if (!isFull()) {
            this.rear++;
            this.queue[this.rear] = value;
        } else {
            System.out.println("the queue is full");
        }
    }

    public int getFromQueue() {
        if (!isEmpty()) {
            this.front++;
            int value = this.queue[this.front];
            for (int x = this.front; x < this.rear; x++) {
                this.queue[x] = this.queue[x + 1];
            }
            this.front--;
            this.rear--;
            return value;
        } else {
            throw new RuntimeException("The queue is empty");
        }
    }

    public boolean isFull() {
        return this.rear == this.maxSize - 1;
    }

    public boolean isEmpty() {
        return this.front == this.rear;
    }

    @Override
    public String toString() {
        return "MyQueue{" +
                "maxSize=" + maxSize +
                ", front=" + front +
                ", rear=" + rear +
                '}';
    }

    public void showQueue() {
        if (!this.isEmpty()) {
            for (int x = this.front + 1; x <= this.rear; x++) {
                System.out.print(this.queue[x]);
                if (x != this.rear) {
                    System.out.print(",");
                }
            }
        }
    }
}
