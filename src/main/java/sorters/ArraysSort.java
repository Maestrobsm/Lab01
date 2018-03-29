package sorters;


import java.util.Arrays;

/**
 * Implementation of {@link Sorter} class.
 * Uses Array.sort.
 */
public class ArraysSort extends Sorter {
    /**
     * Method that uses the built-in function Arrays.sort for sorting array.
     *
     * @param array input array.
     * @return sorted array.
     */
    public int[] sort(int[] array) {
        if (array != null ) {
            if(array.length > 0){
                Arrays.sort(array);
            }else System.out.println("Недопустимый размер массива");
        }else System.out.println("Пустая ссылка на массив");
        return array;
    }

}
