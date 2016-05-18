package sinthu94.algorithm;

/**
 * Created by sinthu on 09.05.16.
 */
public class MyBubbleSort<T> implements MySorter<T> {

    private MyComparator<T> comparator;

    public MyBubbleSort(MyComparator<T> comparator) {
        this.comparator = comparator;
    }

    private T[] sortIntern(T[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (comparator.compare(array[i], array[i + 1])) {
                continue;
            }
            T k = array[i];
            array[i] = array[i + 1];
            array[i + 1] = k;
            sortIntern(array);
        }

        return array;
    }

    @Override
    public T[] sort(T[] array) {
        return sortIntern(array);
    }
}
