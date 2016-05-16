package sinthu94.tree;

import org.junit.Before;
import org.junit.Test;
import sinthu94.sort.MyComparator;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

/**
 * Created by sinthu on 12.05.16.
 */
public class MyBinaryTreeTest {

    private MyBinaryTree<Integer> tree;

    private Integer forTestNode;

    @Before
    public void setUp() throws Exception {
        tree = new MyBinaryTree<>(new MyComparator<Integer>() {
            @Override
            public boolean compare(Integer a, Integer b) {
                return a <= b;
            }

            @Override
            public boolean equals(Integer a, Integer b) {
                return a.equals(b);
            }
        });
        tree.addNode(new MyNode<>(new Integer(10)));
    }


    @Test
    public void testAddNode() {
        forTestNode = new Integer(9);
        tree.addNode(new MyNode<>(forTestNode));
        assertThat(tree.getNodesInOrder(tree.getRoot()).get(0).getNode(), is(equalTo(forTestNode)));
    }

    @Test
    public void testFind() {
        forTestNode = new Integer(5);
        tree.addNode(new MyNode<>(forTestNode));
        forTestNode = new Integer(1);
        tree.addNode(new MyNode<>(forTestNode));
        assertThat(tree.find(forTestNode).isPresent(), is(true));
    }

    @Test
    public void testRemoveNode() {
        forTestNode = new Integer(5);
        tree.addNode(new MyNode<>(forTestNode));
        forTestNode = new Integer(1);
        tree.addNode(new MyNode<>(forTestNode));
        forTestNode = new Integer(3);
        tree.addNode(new MyNode<>(forTestNode));
        forTestNode = new Integer(76);
        tree.addNode(new MyNode<>(forTestNode));
        forTestNode = new Integer(21);
        tree.addNode(new MyNode<>(forTestNode));
        forTestNode = new Integer(100);
        tree.addNode(new MyNode<>(forTestNode));

        assertThat(tree.getSize(), is(7));
        tree.removeNode(new MyNode<>(forTestNode));
        assertThat(tree.getSize(), is(6));
    }

    @Test
    public void testGetNodesInOrder() {
        MyNode<Integer> number4 = new MyNode<>(new Integer(100));
        tree.addNode(number4);

        MyNode<Integer> number6 = new MyNode<>(new Integer(1000));
        tree.addNode(number6);

        MyNode<Integer> number7 = new MyNode<>(new Integer(5000));
        tree.addNode(number7);

        MyNode<Integer> number3 = new MyNode<>(new Integer(50));
        tree.addNode(number3);

        MyNode<Integer> number5 = new MyNode<>(new Integer(500));
        tree.addNode(number5);

        MyNode<Integer> number1 = new MyNode<>(new Integer(5));
        tree.addNode(number1);

        List<MyNode<Integer>> res = Arrays.asList(number1, tree.getRoot(), number3, number4, number5, number6, number7);

        assertEquals(tree.getNodesInOrder(tree.getRoot()), res);
    }

    @Test
    public void testGetRoot() {

    }

    @Test
    public void testGetSize() {
        tree.addNode(new MyNode<>(new Integer(5)));
        tree.addNode(new MyNode<>(new Integer(1)));
        tree.addNode(new MyNode<>(new Integer(2)));
        tree.addNode(new MyNode<>(new Integer(3)));
        tree.addNode(new MyNode<>(new Integer(6)));
        tree.addNode(new MyNode<>(new Integer(7)));
        
        tree.removeNode(new MyNode<>(new Integer(7)));
        assertThat(tree.getSize(), is(6));
    }
}