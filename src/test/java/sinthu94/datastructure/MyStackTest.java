package sinthu94.datastructure;

import org.junit.Before;
import org.junit.Test;
import sinthu94.datastructure.MyStack;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


/**
 * Created by sinthu on 16.05.16.
 */
public class MyStackTest {

    private MyStack<Integer> stack;

    @Before
    public void setUp() {
        stack = new MyStack<>();
    }

    @Test
    public void testPush() {
        for (int i = 0; i < 21; i++) {
            stack.push(new Integer(i));
        }
        assertThat(stack.top().get(), is(new Integer(20)));
    }

    @Test
    public void testPushMultipleItems() {
        stack.pushMultipleItems(new Integer(0), new Integer(12), new Integer(50), new Integer(1), new Integer(4), new Integer(3));
        assertThat(stack.top().get(), is(new Integer(3)));
    }

    @Test
    public void testPop() {
        for (int i = 0; i < 25; i++) {
            stack.push(new Integer(i));
        }
        assertThat(stack.pop().get(), is(new Integer(24)));
    }

    @Test
    public void testPopAll() {
        for (int i = 0; i < 25; i++) {
            stack.push(new Integer(i));
        }
        stack.popAll();
        assertThat(stack.getSize(), is(0));
    }

    @Test
    public void testTop() {
        for (int i = 0; i < 150; i++) {
            stack.push(new Integer(i));
        }
        stack.push(new Integer(1000));
        assertThat(stack.top().get(), is(new Integer(1000)));
    }

    @Test
    public void testGetSize() {
        for (int i = 0; i < 150; i++) {
            stack.push(new Integer(i));
        }
        stack.pop();
        stack.pop();
        assertThat(stack.getSize(), is(148));
    }
}