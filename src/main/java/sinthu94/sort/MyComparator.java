package sinthu94.sort;

/**
 * Created by sinthu on 08.05.16.
 */
@FunctionalInterface
public interface MyComparator<T> {

    boolean compare(T a, T b);

}
