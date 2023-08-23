public class hw2 {
    public static void main(String[] args) {

        int[] array = ex1.getRandomArr(15, 1, 100);
        ex1.printArr(array);

        heapSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    private static void heapSort(int[] array) {

        int n = array.length;
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(array, i, n);

        for (int i = n - 1; i >= 0; i--) {
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            heapify(array, 0, i);
        }
    }

    private static void heapify(int[] array, int i, int n) {
        int l = i * 2 + 1;
        int r = i * 2 + 2;
        int largest = i;

        if (l < n && array[l] > array[largest])
            largest = l;
        if (r < n && array[r] > array[largest])
            largest = r;

        if (i != largest) {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;

            heapify(array, largest, n);
        }
    }
}
