package sinthu94.search;

import sinthu94.sort.MyComparator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by sinthu on 10.05.16.
 */
public class MyBinaryTree<T> {

    private MyNode<T> root;
    private int size;
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
            size++;
        } else {
            Optional<MyNode<T>> currentNode = Optional.of(root);
            MyNode<T> parent;
            while (true) {
                parent = currentNode.get();
                if (myComparator.compare(myNode.getNode(), currentNode.get().getNode())) {
                    currentNode = parent.getLeftChild();
                    if (!currentNode.isPresent()) {
                        parent.setLeftChild(myNode);
                        size++;
                        return;
                    }
                } else {
                    currentNode = parent.getRightChild();
                    if (!currentNode.isPresent()) {
                        parent.setRightChild(myNode);
                        size++;
                        return;
                    }
                }

            }
        }
    }

    public Optional<MyNode<T>> find(T toFind) {
        Optional<MyNode<T>> currentNode = Optional.of(root);
        while (!areEqual(currentNode.get().getNode(), toFind)) {
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

    public boolean removeNode(MyNode<T> toDelete) {
        Optional<MyNode<T>> currentNode = Optional.of(root);
        MyNode<T> parent = root;
        boolean isLeft = true;

        while (!areEqual(toDelete.getNode(), currentNode.get().getNode())) {

            parent = currentNode.get();

            if (myComparator.compare(toDelete.getNode(), currentNode.get().getNode())) {
                currentNode = currentNode.get().getLeftChild();
                isLeft = true;
            } else {
                currentNode = currentNode.get().getRightChild();
                isLeft = false;
            }

            if (!currentNode.isPresent()) {
                return false;
            }
        }

        replaceNode(currentNode, parent, isLeft);
        size--;
        return true;
    }

    private void replaceNode(Optional<MyNode<T>> currentNode, MyNode<T> parent, boolean isLeft) {
        final boolean rightChildEmpty = !currentNode.get().getRightChild().isPresent();
        final boolean leftChildEmpty = !currentNode.get().getLeftChild().isPresent();
        final boolean bothChildEmpty = rightChildEmpty && leftChildEmpty;

        if (bothChildEmpty) {

            if (isRoot(currentNode.get().getNode())) {
                root = null;
            } else if (isLeft) {
                parent.setLeftChild(null);
            } else {
                parent.setRightChild(null);
            }

        } else if (rightChildEmpty) {

            if (isRoot(currentNode.get().getNode())) {
                root = currentNode.get().getLeftChild().get();
            } else if (isLeft) {
                parent.setLeftChild(currentNode.get().getLeftChild().get());
            } else {
                parent.setRightChild(currentNode.get().getLeftChild().get());
            }

        } else if (leftChildEmpty) {

            if (isRoot(currentNode.get().getNode())) {
                root = currentNode.get().getRightChild().get();
            } else if (isLeft) {
                parent.setLeftChild(currentNode.get().getRightChild().get());
            } else {
                parent.setRightChild(currentNode.get().getRightChild().get());
            }

        } else {
            MyNode<T> replacement = getReplacement(currentNode.get());

            if (isRoot(currentNode.get().getNode())) {
                root = replacement;
            } else if (isLeft) {
                parent.setLeftChild(replacement);
            } else {
                parent.setRightChild(replacement);
            }

            replacement.setLeftChild(currentNode.get().getLeftChild().get());
        }
    }

    private MyNode<T> getReplacement(MyNode<T> toReplace) {
        MyNode<T> replacementParent = toReplace;
        MyNode<T> replacement = toReplace;
        Optional<MyNode<T>> currentNode = toReplace.getRightChild();

        while (currentNode.isPresent()) {
            replacementParent = replacement;
            replacement = currentNode.get();
            currentNode = currentNode.get().getLeftChild();
        }

        if (!areEqual(replacement.getNode(), toReplace.getRightChild().get().getNode())) {
            replacementParent.setLeftChild(replacement.getRightChild().get());
            replacement.setRightChild(toReplace.getRightChild().get());
        }

        return replacement;
    }

    private boolean isRoot(T node) {
        return myComparator.equals(node, root.getNode());
    }

    private boolean areEqual(T a, T b) {
        return myComparator.equals(a, b);
    }

    public List<MyNode<T>> getNodesInOrder(Optional<MyNode<T>> start) {
        List<MyNode<T>> myNodes = new ArrayList<>();
        if (start.isPresent()) {
            myNodes.addAll(getNodesInOrder(start.get().getLeftChild()));
            myNodes.add(start.get());
            myNodes.addAll(getNodesInOrder(start.get().getRightChild()));
        }
        return myNodes;
    }

    public MyNode<T> getRoot() {
        return root;
    }

    public int getSize() {
        return size;
    }
}
