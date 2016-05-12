package sinthu94.sort;

/**
 * Created by sinthu on 08.05.16.
 */
public class MyMergeSort<T> implements MySorter<T> {

    private MyComparator<T> comparator;
    private T[] array;

    public MyMergeSort(MyComparator<T> comparator) {
        this.comparator = comparator;
    }

    private T[] sortIntern(int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;

            sortIntern(l, m);
            sortIntern(m + 1, r);
            merge(l, m, r);
        }
        return array;
    }

    private void merge(int l, int m, int r) {
        T[] arr = (T[]) new Object[array.length];

        int i, j;

        for (i = l; i <= m; i++) {
            arr[i] = array[i];
        }

        for (j = m + 1; j <= r; j++) {
            arr[r + m + 1 - j] = array[j];
        }

        i = l;
        j = r;

        for (int k = l; k <= r; k++) {
            if (comparator.compare(arr[i], arr[j])) {
                array[k] = arr[i];
                i++;
            } else {
                array[k] = arr[j];
                j--;
            }
        }
    }

    public T[] sort(T[] array) {
        this.array = array;
        return sortIntern(0, array.length - 1);
    }
}
