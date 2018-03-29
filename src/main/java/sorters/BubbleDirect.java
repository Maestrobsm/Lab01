package sorters;

/**
 * Implementation of {@link Sorter} class.
 * Uses bubble direct sort.
 */
public class BubbleDirect extends BubbleSort {

    @Override
    public int newIterator(int[] array) {
        return 1;
    }

    @Override
    public boolean limit(int[] array, int i, int j) {
        return j <= (array.length - i);
    }

    @Override
    public int iterator(int j) {
        return j + 1;
    }
}
