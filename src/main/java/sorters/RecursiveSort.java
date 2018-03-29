package sorters;

/**
 * Implementation of {@link Sorter} class.
 * Uses recursive sort.
 */
public class RecursiveSort extends Sorter {

    /**
     * The method for sorting is based on recursion, uses the swap() and sortRecursive() methods.
     * @see sorters.Sorter#swap(int[], int, int).
     * @see sorters.RecursiveSort#sortRecursive(int[], int, int).
     * @param arr input array.
     * @return sorted array.
     */
    public int[] sort(int[] arr) {
        int begin = 0;
        int end = arr.length-1;
        return sortRecursive(arr, begin, end);
    }

    /**
     * Implementation of the recursive method itself.
     * @param A - input array.
     * @param left - limit value on the left.
     * @param right - limit value on the right.
     * @return sorted array.
     */
    private int[] sortRecursive(int[] A, int left, int right) {
        int i;
        int j;
        int s;
        if (right <= left)
            return A;
        s = A[(left + right) / 2];
        i = left;
        j = right;
        while (i <= j) {
            while (A[i] < s) {
                i = i + 1;
            }
            while (A[j] > s) {
                j = j - 1;
            }
            if (i <= j) {
                swap(A, i, j);
                i = i + 1;
                j = j - 1;
            }
        }
        if (left < j) {
            sortRecursive(A, left, j);
        }
        if (i < right) {
            sortRecursive(A, i, right);
        }
        return A;
    }
}