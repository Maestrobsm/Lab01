package sorters;

import java.util.Arrays;


/**
 * Implementation of {@link Sorter} class.
 * Uses merger sort.
 */
public class MergerSort extends Sorter {

    /**
     * The method is based on the sorting of the merge, uses the method swap() and merge().
     *
     * @param arr input array.
     * @return sorted array.
     * @see sorters.Sorter#swap(int[], int, int).
     * @see sorters.MergerSort#merge(int[], int[])
     */
    public int[] sort(int[] arr) {
        if (arr != null) {
            if (arr.length > 0) {
                int len = arr.length;
                if (len < 2) return arr;
                int middle = len / 2;
                arr = merge(sort(Arrays.copyOfRange(arr, 0, middle)),
                        sort(Arrays.copyOfRange(arr, middle, len)));
            }else System.out.println("Недопустимый размер массива");
        }else System.out.println("Пустая ссылка на массив");
        return arr;
    }

    /**
     * The method of merging two arrays.
     *
     * @param arr_1 - first array.
     * @param arr_2 - second array.
     * @return - merge array.
     */
    private static int[] merge(int[] arr_1, int[] arr_2) {
        int len_1 = arr_1.length, len_2 = arr_2.length;
        int a = 0, b = 0, len = len_1 + len_2;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            if (b < len_2 && a < len_1) {
                if (arr_1[a] > arr_2[b]) result[i] = arr_2[b++];
                else result[i] = arr_1[a++];
            } else if (b < len_2) {
                result[i] = arr_2[b++];
            } else {
                result[i] = arr_1[a++];
            }
        }
        return result;
    }

}
