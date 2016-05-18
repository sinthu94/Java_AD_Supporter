package sinthu94.algorithm;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by sinthu on 08.05.16.
 */
public class MyMergeSortTest {

    private Integer[] input;
    private Integer[] output;
    private MyMergeSort<Integer> myMergeSort;
    private MyComparator<Integer> myComparator;

    @Before
    public void setUp() {
        input = new Integer[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        output = new Integer[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        myComparator = new MyComparator<Integer>() {
            @Override
            public boolean compare(Integer a, Integer b) {
                return a <= b;
            }

            @Override
            public boolean equals(Integer a, Integer b) {
                return a.equals(b);
            }
        };
        myMergeSort = new MyMergeSort<>(myComparator);
    }

    @Test
    public void testSort() {
        Integer[] result = myMergeSort.sort(input);
        for (int i = 0; i < input.length; i++) {
            System.out.println(input[i] + " <-> " + output[i]);
        }
        assertArrayEquals(output, result);
    }

}