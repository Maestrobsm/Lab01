
import org.junit.Test;
import sorters.*;

import static org.junit.Assert.assertArrayEquals;

public class TestSorts {
    final int[] ARRAY = {9, 1, 6, 5, 3, 2, 10, 7};
    final int[] SORTED_ARRAY = {1, 2, 3, 5, 6, 7, 9, 10};

    @Test
    public void arraySortTest() {
        Sorter arraysSort = new ArraysSort();
        assertArrayEquals(SORTED_ARRAY, arraysSort.sort(ARRAY));
    }

    @Test
    public void bubbleDirectTest() {
        Sorter arraysSort = new BubbleDirect();
        assertArrayEquals(SORTED_ARRAY, arraysSort.sort(ARRAY));
    }

    @Test
    public void bubbleReverseTest() {
        Sorter arraysSort = new BubbleReverse();
        assertArrayEquals(SORTED_ARRAY, arraysSort.sort(ARRAY));
    }

    @Test
    public void exchangeSortTest() {
        Sorter arraysSort = new ExchangeSort();
        assertArrayEquals(SORTED_ARRAY, arraysSort.sort(ARRAY));
    }

    @Test
    public void mergerSortTest() {
        Sorter arraysSort = new MergerSort();
        assertArrayEquals(SORTED_ARRAY, arraysSort.sort(ARRAY));
    }

    @Test
    public void recursiveSortTest() {
        Sorter arraysSort = new RecursiveSort();
        assertArrayEquals(SORTED_ARRAY, arraysSort.sort(ARRAY));
    }
}