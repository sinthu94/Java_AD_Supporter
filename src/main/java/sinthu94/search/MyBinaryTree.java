package sinthu94.search;

import sinthu94.sort.MyComparator;

import java.util.Optional;

/**
 * Created by sinthu on 10.05.16.
 */
public class MyBinaryTree<T> {

    private MyNode<T> root;
    private MyComparator<T> myComparator;

    public MyBinaryTree(MyComparator<T> comparator) {
        myComparator = comparator;
    }

    public MyBinaryTree(MyComparator<T> comparator, MyNode<T> root) {
        myComparator = comparator;
        addNode(root);
    }

    public void addNode(MyNode<T> myNode) {
        if (root == null) {
            root = myNode;
        } else {
            Optional<MyNode<T>> currentNode = Optional.of(root);
            MyNode<T> parent;
            while (true) {
                parent = currentNode.get();
                if (myComparator.compare(myNode.getNode(), currentNode.get().getNode())) {
                    currentNode = parent.getLeftChild();
                    if (!currentNode.isPresent()) {
                        parent.setLeftChild(myNode);
                        return;
                    }
                } else {
                    currentNode = parent.getRightChild();
                    if (!currentNode.isPresent()) {
                        parent.setRightChild(myNode);
                        return;
                    }
                }

            }
        }
    }

    public Optional<MyNode<T>> find(T toFind) {
        Optional<MyNode<T>> currentNode = Optional.of(root);
        while (!myComparator.equals(currentNode.get().getNode(), toFind)) {
            if (myComparator.compare(toFind, currentNode.get().getNode())) {
                currentNode = currentNode.get().getLeftChild();
            } else {
                currentNode = currentNode.get().getRightChild();
            }

            if (!currentNode.isPresent()) {
                return Optional.ofNullable(null);
            }
        }
        return currentNode;
    }

    public void traverseInOrder(Optional<MyNode<T>> start) {
        if (start.isPresent()) {
            traverseInOrder(start.get().getLeftChild());
            System.out.println(start.get().getNode());
            traverseInOrder(start.get().getRightChild());
        }
    }


    public MyNode<T> getRoot() {
        return root;
    }
}
