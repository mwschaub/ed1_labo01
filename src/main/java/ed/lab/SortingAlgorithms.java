package ed.lab;

import java.util.Random;

public class SortingAlgorithms {
    public static void highPivotQuickSort(String[] array) {
        quickSort(array, 0, array.length - 1, "high");
    }

    public static void lowPivotQuickSort(String[] array) {
        quickSort(array, 0, array.length - 1, "low");
    }

    public static void randomPivotQuickSort(String[] array) {
        quickSort(array, 0, array.length - 1, "random");
    }

    private static void quickSort(String[] array, int low, int high, String pivotType) {
        if (low < high) {
            int pivotIndex = switch (pivotType) {
                case "high" -> high;
                case "low" -> low;
                case "random" -> new Random().nextInt(high - low + 1) + low;
                default -> high;
            };

            String pivot = array[pivotIndex];
            swap(array, pivotIndex, high);

            int partitionIndex = partition(array, low, high, pivot);
            quickSort(array, low, partitionIndex - 1, pivotType);
            quickSort(array, partitionIndex + 1, high, pivotType);
        }
    }

    private static int partition(String[] array, int low, int high, String pivot) {
        int i = low;
        for (int j = low; j < high; j++) {
            if (array[j].compareTo(pivot) < 0) {
                swap(array, i, j);
                i++;
            }
        }
        swap(array, i, high);
        return i;
    }

    private static void swap(String[] array, int i, int j) {
        String temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

