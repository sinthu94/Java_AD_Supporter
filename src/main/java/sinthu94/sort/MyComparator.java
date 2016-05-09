package sinthu94.sort;

/**
 * Created by sinthu on 08.05.16.
 */
@FunctionalInterface
public interface MyComparator<T> {

    /**
     * @param a first object
     * @param b second object
     * @return true if a is smaller then b
     */
    boolean compare(T a, T b);

}
