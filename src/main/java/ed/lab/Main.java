package ed.lab;

import java.util.Random;
import java.util.stream.IntStream;

public class Main {
    private static final ArrayGenerator<String> sortedArrayGenerator = (length) -> {
        String[] arr = new String[length];
        for (int i = 0; i < length; i++) {
            arr[i] = String.valueOf((char) ('A' + i % 26)); // Genera letras ordenadas (A-Z repetidas)
        }
        return arr;
    };

    private static final ArrayGenerator<String> invertedArrayGenerator = (length) -> {
        String[] arr = sortedArrayGenerator.generate(length);
        for (int i = 0; i < length / 2; i++) {
            String temp = arr[i];
            arr[i] = arr[length - i - 1];
            arr[length - i - 1] = temp;
        }
        return arr;
    };

    private static final ArrayGenerator<String> randomArrayGenerator = (length) -> {
        Random rand = new Random();
        return IntStream.range(0, length)
                .mapToObj(i -> String.valueOf((char) ('A' + rand.nextInt(26))))
                .toArray(String[]::new);
    };

    private static final QuickSort<String> highPivotQuickSort = SortingAlgorithms::highPivotQuickSort;
    private static final QuickSort<String> lowPivotQuickSort = SortingAlgorithms::lowPivotQuickSort;
    private static final QuickSort<String> randomPivotQuickSort = SortingAlgorithms::randomPivotQuickSort;

    public static void main(String[] args) {
        final SortingTester<String> tester = new SortingTester<>();

        System.out.println("Ordenando un arreglo ordenado:");
        System.out.println("\tUtilizando el último elemento como pivote: ");
        tester.testSorting(sortedArrayGenerator, highPivotQuickSort);
        System.out.println("\tUtilizando el primer elemento como pivote: ");
        tester.testSorting(sortedArrayGenerator, lowPivotQuickSort);
        System.out.println("\tUtilizando un elemento aleatorio como pivote: ");
        tester.testSorting(sortedArrayGenerator, randomPivotQuickSort);
        System.out.println("================================");

        System.out.println("Ordenando un arreglo invertido:");
        System.out.println("\tUtilizando el último elemento como pivote: ");
        tester.testSorting(invertedArrayGenerator, highPivotQuickSort);
        System.out.println("\tUtilizando el primer elemento como pivote: ");
        tester.testSorting(invertedArrayGenerator, lowPivotQuickSort);
        System.out.println("\tUtilizando un elemento aleatorio como pivote: ");
        tester.testSorting(invertedArrayGenerator, randomPivotQuickSort);
        System.out.println("================================");

        System.out.println("Ordenando un arreglo aleatorio:");
        System.out.println("\tUtilizando el último elemento como pivote: ");
        tester.testSorting(randomArrayGenerator, highPivotQuickSort);
        System.out.println("\tUtilizando el primer elemento como pivote: ");
        tester.testSorting(randomArrayGenerator, lowPivotQuickSort);
        System.out.println("\tUtilizando un elemento aleatorio como pivote: ");
        tester.testSorting(randomArrayGenerator, randomPivotQuickSort);
        System.out.println("================================");
    }
}
