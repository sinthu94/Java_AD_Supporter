package sinthu94.sort;

/**
 * Created by sinthu on 09.05.16.
 */
public class MyRippleSort<T> implements MySorter<T> {

    private MyComparator<T> comparator;

    public MyRippleSort(MyComparator<T> comparator) {
        this.comparator = comparator;
    }

    private T[] sortIntern(T[] array) {
        boolean switched;
        do {
            switched = false;
            for (int i = 0; i < array.length-1; i++) {
                if (!comparator.compare(array[i], array[i+1])) {
                    T k = array[i];
                    array[i] = array[i+1];
                    array[i+1] = k;
                    switched = true;
                }
            }
        } while (switched);

        return array;
    }

    @Override
    public T[] sort(T[] array) {
        return sortIntern(array);
    }
}
