package HW3_divide_conquer.BinarySearch;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfTest = scanner.nextInt();
        for(int i = 0; i < numOfTest; i++) {
            int n = scanner.nextInt();
            int target = scanner.nextInt();
            int[] array = new int[n];
            for (int j = 0; j < n; j++) array[j] = scanner.nextInt();
            System.out.println(BinarySearch(array, target, 0, n - 1));
        }
    }
    static int BinarySearch(int[] array, int target, int start, int end){
        if(end < start) return -1;
        else{
            int mid = (start + end) / 2;
            if(target < array[mid]) return BinarySearch(array, target, start, mid - 1);
            else if(array[mid] < target) return BinarySearch(array, target, mid + 1, end);
            else return mid;
        }
    }
}
