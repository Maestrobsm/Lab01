package sorters;

import analyzer.Service;

/**
 * Abstract class for sorting arrays.
 */
@Service
public abstract class Sorter {

    /**
     * Array sorter.
     * @param array - input array for sorting.
     * @return - sorted array.
     */
    public abstract int[] sort(int[] array);

    /**
     * Method of exchanging two elements.
     *
     * @param array - input array.
     * @param i     - value of the variable i;
     * @param j     - value of the variable j;
     */
    protected static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

