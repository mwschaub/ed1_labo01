package ed.lab;

import java.util.Random;

public class SortingAlgorithms {
    public static <T extends Comparable<T>> void highPivotQuickSort(T[] array) {
        quickSort(array, 0, array.length - 1, "high");
    }

    public static <T extends Comparable<T>> void lowPivotQuickSort(T[] array) {
        quickSort(array, 0, array.length - 1, "low");
    }

    public static <T extends Comparable<T>> void randomPivotQuickSort(T[] array) {
        quickSort(array, 0, array.length - 1, "random");
    }

    private static <T extends Comparable<T>> void quickSort(T[] array, int left, int right, String pivotType) {
        if (left < right) {
            int pivotIndex;
            if ("high".equals(pivotType)) {
                pivotIndex = right;
            } else if ("low".equals(pivotType)) {
                pivotIndex = left;
            } else {
                pivotIndex = new Random().nextInt(right - left + 1) + left; // Aleatorio
            }

            pivotIndex = partition(array, left, right, pivotIndex);
            quickSort(array, left, pivotIndex - 1, pivotType);
            quickSort(array, pivotIndex + 1, right, pivotType);
        }
    }

    private static <T extends Comparable<T>> int partition(T[] array, int left, int right, int pivotIndex) {
        T pivotValue = array[pivotIndex];
        swap(array, pivotIndex, right);
        int storeIndex = left;

        for (int i = left; i < right; i++) {
            if (array[i].compareTo(pivotValue) < 0) {
                swap(array, i, storeIndex);
                storeIndex++;
            }
        }
        swap(array, storeIndex, right);
        return storeIndex;
    }

    private static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}


