package sinthu94.algorithm;

/**
 * Created by sinthu on 08.05.16.
 */
public interface MyComparator<T> {

    /**
     * @param a first object
     * @param b second object
     * @return true if a is smaller then b
     */
    boolean compare(T a, T b);

    boolean equals(T a, T b);
}
