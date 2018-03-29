import org.junit.Test;

import static fillers.Fillers.*;
import static fillers.Fillers.sortedArrayRandom;
import static junit.framework.Assert.assertTrue;

public class TestFillers {
    final int NEGATIVE_SIZE = -1;
    final int SIZE = 10;
    int[] array = new int[SIZE];

    @Test(expected = NegativeArraySizeException.class)
    public void negativeSizeSA() {
        sortedArray(NEGATIVE_SIZE);
    }

    @Test(expected = NegativeArraySizeException.class)
    public void negativeSizeSARand() {
        sortedArrayRandom(NEGATIVE_SIZE);
    }

    @Test(expected = NegativeArraySizeException.class)
    public void negativeSizeSARev() {
        sortedArrayReverse(NEGATIVE_SIZE);
    }

    @Test(expected = NegativeArraySizeException.class)
    public void negativeSizeRA() {
        randomArray(NEGATIVE_SIZE);
    }

    @Test
    public void sizeSA() {
        array = sortedArray(SIZE);
        assertTrue(SIZE == array.length);
    }

    @Test
    public void sizeSARand() {
        array = sortedArrayRandom(SIZE);
        assertTrue(SIZE+1 == array.length);
    }

    @Test
    public void sizeSARev() {
        array = sortedArrayReverse(SIZE);
        assertTrue(SIZE == array.length);
    }

    @Test
    public void sizeRA() {
        array = randomArray(SIZE);
        assertTrue(SIZE == array.length);
    }

    @Test
    public void isRandom() {
        array = randomArray(SIZE);
        int quantityTrue = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1]) {
                quantityTrue += 1;
            }
        }
        assertTrue(quantityTrue < (SIZE - 1));
    }

    @Test
    public void isSortedArray() {
        array = sortedArray(SIZE);
        int quantityTrue = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1]) {
                quantityTrue += 1;
            }
        }
        assertTrue(quantityTrue == (SIZE - 1));
    }

    @Test
    public void isSortedArrayReverse() {
        array = sortedArrayReverse(SIZE);
        int quantityTrue = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                quantityTrue += 1;
            }
        }
        assertTrue(quantityTrue == (SIZE - 1));
    }

    @Test
    public void isSortedArrayRandom() {
        int quantityTrue = 0;
        int times = 10;
        for (int i = 0; i < times; i++) {
            array = sortedArrayRandom(SIZE);
            if (array[SIZE-1] < array[SIZE]) {
                quantityTrue += 1;
            }
        }
        assertTrue(times!=quantityTrue);
    }

}