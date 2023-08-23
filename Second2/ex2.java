import java.util.Date;
import java.util.Arrays;

public class ex2 {
    public static void main(String[] args) {
        int size = 10000;
        int min = 0;
        int max = 100;
        // int[] array = ex1.getRandomArr(size, min, max);
        // ex1.printArr(array);
        // quickSort(array);
        // ex1.printArr(array);

        Date date = new Date();
        int[] array = ex1.getRandomArr(size, min, max);
        long start = new Date().getTime();
        ex1.bubbleSort(array.clone());
        long end = new Date().getTime();
        System.out.println(end - start);
        long start2 = new Date().getTime();
        quickSort(array.clone());
        long end2 = new Date().getTime();
        System.out.println(end2 - start2);
        long start3 = new Date().getTime();
        Arrays.sort(array.clone());
        long end3 = new Date().getTime();
        System.out.println(end3 - start3);  

    }

    /**
     * @param array - исходный массив
     * @apiNote Перегрузка метода быстрой сортировки
     */
    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    /**
     * @param array         - исходный массив
     * @param startPosition - начало массива
     * @param endPosition   - конец массива
     * @apiNote Метод реализующий быструю сортировку, принимающий на вход три
     *          аргумента
     */
    public static void quickSort(int[] array, int startPosition, int endPosition) {
        int pivot = array[(startPosition + endPosition) / 2];
        int i = startPosition, j = endPosition;
        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                if (i < j) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
                i++;
                j--;
            }
        }
        if (i < endPosition) {
            quickSort(array, i, endPosition);
        }
        if (j > startPosition) {
            quickSort(array, startPosition, j);
        }
    }
}
