package sorters;

/**
 * Implementation of {@link Sorter} class.
 * Abstract class for sorting arrays by bubble method.
 */

public abstract class BubbleSort extends Sorter {

    /**
     * Method for sorting is based on bulb sorting, uses the method swap().
     *
     * @param array input array.
     * @return sorted array.
     * @see sorters.Sorter#swap(int[], int, int).
     */
    public int[] sort(int[] array) {
        if (array != null) {
            if (array.length > 0) {
                for (int i = 1; i < array.length; i++) {
                    for (int j = newIterator(array); limit(array, i, j); j = iterator(j)) {
                        if (array[j - 1] > array[j]) {
                            swap(array, j, j - 1);
                        }
                    }
                }

            } else System.out.println("Недопустимый размер массива");
        } else System.out.println("Пустая ссылка на массив");
        return array;
    }

    /**
     * Sets the initial value of the iterator.
     *
     * @param array - input array.
     * @return initial value of the iterator.
     */
    public abstract int newIterator(int[] array);

    /**
     * Checks the possibility of the next iteration.
     *
     * @param array - input array.
     * @param i     - value of the variable i;
     * @param j     - value of the variable j;
     * @return boolean.
     */
    public abstract boolean limit(int[] array, int i, int j);

    /**
     * Changes the value of the variable in a given direction.
     *
     * @param j - value of the variable j.
     * @return value of the variable.
     */
    public abstract int iterator(int j);
}
