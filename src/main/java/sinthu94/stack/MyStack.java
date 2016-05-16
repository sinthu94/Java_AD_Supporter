package sinthu94.stack;

import java.util.Arrays;
import java.util.Optional;

/**
 * Created by sinthu on 15.05.16.
 */
public class MyStack<T> {

    private T[] stack;
    private int stackSize;
    private int size;
    private int topOfStack;

    public MyStack() {
        initStack();
    }

    public void push(T item) {
        if (size >= stackSize) {
            doubleStackSize();
        }
        topOfStack++;
        stack[topOfStack] = item;
        size++;
    }

    public void pushMultipleItems(T... items) {
        for (int i = 0; i < items.length; i++) {
            push(items[i]);
        }
    }

    public Optional<T> pop() {
        if (size == 0) {
            return Optional.empty();
        }

        T topItem = stack[topOfStack];
        topOfStack--;
        size--;

        if (size <= stackSize / 2) {
            halveStackSize();
        }

        return Optional.of(topItem);
    }

    public void popAll() {
        initStack();
    }

    public Optional<T> top() {
        if (size == 0) {
            return Optional.empty();
        }
        return Optional.of(stack[topOfStack]);
    }

    public int getSize() {
        return size;
    }

    private void initStack() {
        stackSize = 10;
        stack = (T[]) new Object[stackSize];
        size = 0;
        topOfStack = -1;
    }

    private void doubleStackSize() {
        stackSize = stackSize * 2;
        T[] newStack = Arrays.copyOf(stack, stackSize);
        stack = newStack;
    }

    private void halveStackSize() {
        stackSize = stackSize * 2;
        T[] newStack = Arrays.copyOf(stack, stackSize / 2);
        stack = newStack;
    }
}
