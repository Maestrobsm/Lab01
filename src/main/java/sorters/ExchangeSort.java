package sorters;

/**
 * Implementation of {@link Sorter} class.
 * Uses exchange sort.
 */

public class ExchangeSort extends Sorter {

    /**
     * The method for sorting is based on the sorting of the exchange, uses the method swap().
     *
     * @param array input array.
     * @return sorted array.
     * @see sorters.Sorter#swap(int[], int, int).
     */
    public int[] sort(int[] array) {
        if (array != null) {
            if (array.length > 0) {
                for (int i = 0; i < array.length - 1; i++) {
                    for (int j = 0; j < array.length - 1; j++) {
                        if (array[j] > array[j + 1]) {
                            swap(array, j, j + 1);
                        }
                    }
                }
            } else System.out.println("Недопустимый размер массива");
        } else System.out.println("Пустая ссылка на массив");
        return array;
    }
}