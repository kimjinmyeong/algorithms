package dynamic_programming.MultipleChainMatrix;

import java.util.Scanner;

public class MultipleChainMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfCase = scanner.nextInt();
        for (int c = 0; c < numOfCase; c++) {
            int numOfMatrix = scanner.nextInt();
            int[] matrixSize = new int[numOfMatrix + 1];
            int[][] dp = new int[numOfMatrix + 1][numOfMatrix + 1];
            int[][] p = new int[numOfMatrix + 1][numOfMatrix + 1];
            for (int i = 0; i <= numOfMatrix; i++) {
                int size = scanner.nextInt();
                matrixSize[i] = size;
                dp[i][i] = 0;
            }
            multipleMatrix(matrixSize, dp, p, numOfMatrix);
        }
    }

    static void multipleMatrix(int[] matrixSize, int[][] dp, int[][] p, int n) {
        for (int diagonal = 1; diagonal < n; diagonal++) {
            for (int i = 1; i <= n - diagonal; i++) {
                int j = i + diagonal;
                int min = 999999;
                for (int k = i; k < j; k++) {
                    dp[i][j] = dp[i][k]
                        + dp[k + 1][j]
                        + matrixSize[i - 1] * matrixSize[k] * matrixSize[j];
                    if (dp[i][j] < min) {
                        min = dp[i][j];
                        p[i][j] = k;
                    }
                    dp[i][j] = min;
                }
            }
        }
        printExpression(p, 1, n);
        System.out.println();
        System.out.println(dp[1][n]);
    }

    static void printExpression(int[][] p, int i, int j) {
        if (i == j) {
            System.out.print("M" + i);
        } else {
            int k = p[i][j];
            System.out.print("(");
            printExpression(p, i, k);
            printExpression(p, k + 1, j);
            System.out.print(")");
        }
    }
}
