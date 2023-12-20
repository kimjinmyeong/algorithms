package dynamic_programming;

import java.util.Scanner;

public class main {
    static int numOfHoareSwap;

    static int numOfHoareCompare;

    static int numOfLomutoSwap;

    static int numOfLomutoCompare;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfTest = scanner.nextInt();
        for (int i = 0; i < numOfTest; i++) {
            int n = scanner.nextInt();
            numOfHoareCompare = 0; numOfHoareSwap = 0; numOfLomutoCompare = 0; numOfLomutoSwap = 0;
            int[] array = new int[n]; int[] array2 = new int[n];
            for (int j = 0; j < n; j++) {
                int val = scanner.nextInt();
                array[j] = val;
                array2[j] = val;
            }
            QuickSortByHoare(array, 0, n - 1);
            QuickSortByLomuto(array2, 0, n - 1);
            System.out.printf("%d %d %d %d \n", numOfHoareSwap, numOfLomutoSwap, numOfHoareCompare, numOfLomutoCompare);
        }
    }

    static void QuickSortByHoare(int a[], int low, int high) {
        if (low < high) {
            int pivotpos_Hoare = partitionByHoare(a, low, high);
            QuickSortByHoare(a, low, pivotpos_Hoare);
            QuickSortByHoare(a, pivotpos_Hoare + 1, high);
        }
    }

    static void QuickSortByLomuto(int a[], int low, int high) {
        if (low < high) {
            int pivotpos_Lomuto = partitionByLomuto(a, low, high);
            QuickSortByLomuto(a, low, pivotpos_Lomuto - 1);
            QuickSortByLomuto(a, pivotpos_Lomuto + 1, high);
        }
    }

    static int partitionByHoare(int a[], int low, int high) {
        int i = low - 1;
        int j = high + 1;
        int pivot = a[low];
        while (true) {
            do {
                numOfHoareCompare++;
                i++;
            } while (a[i] < pivot);

            do {
                numOfHoareCompare++;
                j--;
            } while (a[j] > pivot);
            if (i < j) {
                numOfHoareSwap++;
                // swap
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            } else {
                // return pivot
                return j;
            }
        }
    }

    static int partitionByLomuto(int a[], int low, int high) {
        int pivot = a[low];
        int j = low;
        for (int i = low + 1; i <= high; i++) {
            numOfLomutoCompare++;
            if (a[i] < pivot) {
                j += 1;
                // swap
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                numOfLomutoSwap++;
            }
        }
        pivot = j;
        // swap
        numOfLomutoSwap++;
        int tmp = a[pivot];
        a[pivot] = a[low];
        a[low] = tmp;
        return pivot;

    }
}
