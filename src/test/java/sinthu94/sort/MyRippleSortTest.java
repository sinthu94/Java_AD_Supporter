package sinthu94.sort;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by sinthu on 08.05.16.
 */
public class MyRippleSortTest {

    private Integer[] input;
    private Integer[] output;
    private MyRippleSort<Integer> myRippleSort;
    private MyComparator<Integer> myComparator;

    @Before
    public void setUp() {
        input = new Integer[] {3,2,7,2,-6,-3,1};
        output = new Integer[] {-6,-3,1,2,2,3,7};
        myComparator = (a, b) -> a <= b;
        myRippleSort = new MyRippleSort<>(myComparator);
    }

    @Test
    public void testSort() {
        Integer[] result = myRippleSort.sort(input);
        for (int i = 0; i < input.length; i++) {
            System.out.println(input[i] + " <-> " + output[i]);
        }
        assertArrayEquals(output, result);
    }

}