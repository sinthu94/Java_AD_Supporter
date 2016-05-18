package sinthu94.datastructure;

import java.util.Optional;

/**
 * Created by sinthu on 11.05.16.
 */
public class MyNode<T> {

    private T node;

    private Optional<MyNode<T>> leftChild;
    private Optional<MyNode<T>> rightChild;

    public MyNode(T node) {
        this.node = node;
        leftChild = Optional.ofNullable(null);
        rightChild = Optional.ofNullable(null);
    }

    public T getNode() {
        return node;
    }

    public Optional<MyNode<T>> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(MyNode<T> leftChild) {
        this.leftChild = Optional.ofNullable(leftChild);
    }

    public Optional<MyNode<T>> getRightChild() {
        return rightChild;
    }

    public void setRightChild(MyNode<T> rightChild) {
        this.rightChild = Optional.ofNullable(rightChild);
    }
}