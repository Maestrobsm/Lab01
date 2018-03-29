package sorters;

/**
 * Implementation of {@link Sorter} class.
 * Uses bubble reverse sort.
 */
public class BubbleReverse extends BubbleSort {

    @Override
    public int newIterator(int[] array) {
        return array.length - 1;
    }

    @Override
    public boolean limit(int[] array, int i, int j) {
        return j >= i;
    }

    @Override
    public int iterator(int j) {
        return j - 1;
    }
}