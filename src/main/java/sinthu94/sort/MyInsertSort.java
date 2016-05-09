package sinthu94.sort;

/**
 * Created by sinthu on 10.05.16.
 */
public class MyInsertSort<T> implements MySorter<T> {

    private MyComparator<T> comparator;

    public MyInsertSort(MyComparator<T> comparator) {
        this.comparator = comparator;
    }

    private T[] sortIntern(T[] array) {

        for (int i = 0; i < array.length; i++) {
            for (int j = array.length-1; j > 0 ; j--) {
                if (!comparator.compare(array[j-1], array[j])) {
                    T k = array[j];
                    array[j] = array[j-1];
                    array[j-1] = k;
                }
            }
        }

        return array;
    }

    @Override
    public T[] sort(T[] array) {
        return sortIntern(array);
    }
}
