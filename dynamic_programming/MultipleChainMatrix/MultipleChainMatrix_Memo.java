package dynamic_programming.MultipleChainMatrix;

import java.util.Scanner;

public class MultipleChainMatrix_Memo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfCase = scanner.nextInt();
        for (int c = 0; c < numOfCase; c++) {
            int numOfMatrix = scanner.nextInt();
            int[] matrixSize = new int[numOfMatrix + 1];
            int[][] memo = new int[numOfMatrix + 1][numOfMatrix + 1];
            for (int j = 0; j <= numOfMatrix; j++) {
                for (int k = 0; k <= numOfMatrix; k++) {memo[j][k] = -1;}
            }
            for (int i = 0; i <= numOfMatrix; i++) {
                int size = scanner.nextInt();
                matrixSize[i] = size;
            }
            System.out.println(MultipleMatrix(matrixSize, memo, 1, numOfMatrix));
        }
    }

    static int MultipleMatrix(int[] matrixSize, int[][] memo, int i, int j) {
        if (i == j) {return 0;}
        if (memo[i][j] != -1) {return memo[i][j];}
        int min = 999999;
        for (int k = i; k < j; k++) {
            int count = MultipleMatrix(matrixSize, memo, i, k)
                + MultipleMatrix(matrixSize, memo, k + 1, j)
                + matrixSize[i - 1] * matrixSize[k] * matrixSize[j];
            if (count < min) {min = count;}
            memo[i][j] = min;
        }
        return memo[i][j];
    }
}
