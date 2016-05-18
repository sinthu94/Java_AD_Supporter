package sinthu94.datastructure;


import java.util.Optional;

/**
 * Created by sinthu on 16.05.16.
 */
public class MyQueue<T> {

    private T[] queue;
    private int queueSize;
    private int size;
    private int front;
    private int back;

    public MyQueue() {
        initQueue();
    }

    private void initQueue() {
        queueSize = 10;
        queue = (T[]) new Object[queueSize];
        size = 0;
        front = -1;
        back = -1;
    }

    public void insert(T item) {
        if (size >= queueSize) {
            doubleQueueSize();
        }

        back++;
        queue[back] = item;
        size++;
        front = back - (size - 1);
    }

    private void doubleQueueSize() {

    }

    public void remove() {

    }

    private void halveQueueSize() {

    }

    private void reorder() {
        
    }

    public void removeAll() {
        initQueue();
    }

    public Optional<T> first() {
        if (size == 0) {
            return Optional.empty();
        }
        return Optional.of(queue[front]);
    }

    public int getSize() {
        return size;
    }
}
