package fillers;

import analyzer.Init;

/**
 * Class of fillers
 * @author Bogdan Zhuk.
 */

public class Fillers {

    /**
     * Method returns an ordered array starting from 1 of a given length.
     * @param max - maximum number of elements in the array.
     * @return array - filled array.
     */
    @Init
    public static int[] sortedArray(int max) {
        int[] array = new int[max];
        for (int i = 0; i < max; i++) {
            array[i] = i + 1;
        }
        return array;
    }


    /**
     * Method returns an sorted array starting from 1 of a given length + one element randomly.
     * @param max - maximum number of elements in the array.
     * @return array - filled array.
     */
    @Init
    public static int[] sortedArrayRandom(int max) {
        int[] array = new int[max + 1];
        if (max > 0) {
            int random = (int) (Math.random() * 10);
            for (int i = 0; i < max; i++) {
                array[i] = i + 1;
            }
            array[max] = random;
        } else {
            try {
                throw new NegativeArraySizeException();
            } catch (NegativeArraySizeException e) {
                System.out.println("Недопустимый размер массива");
                throw e;
            }
        }
        return array;
    }


    /**
     * Method returns sorted in reverse order array starting from 1 of a given length.
     * @param max - maximum number of elements in the array.
     * @return array - filled array.
     */
    @Init
    public static int[] sortedArrayReverse(int max) {
        int[] array = new int[max];
        for (int i = 0; i < max; i++) {
            array[i] = max - i;
        }
        return array;
    }


    /**
     * Method returns array of random numbers of a given length.
     * @param max - maximum number of elements in the array.
     * @return array - filled array.
     */
    @Init
    public static int[] randomArray(int max) {
        int[] array = new int[max];
        for (int i = 0; i < max; i++) {
            int random = (int) (Math.random() * 10);
            array[i] = random;
        }
        return array;
    }
}