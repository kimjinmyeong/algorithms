package dynamic_programming.BalanceScale;

import java.util.Scanner;

public class BalanceScale {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfCase = scanner.nextInt();
        for (int c = 0; c < numOfCase; c++) {
            int numOfInput = scanner.nextInt();
            int gap = 0;
            for (int i = 1; i <= numOfInput; i++) {
                int tmp = scanner.nextInt();
                if (gap <= 0) {
                    gap += tmp; // put weight right
                } else {
                    gap -= tmp; // put weight left
                }
            }
            if (gap < 0) {
                gap *= -1;
            }
            if (gap == 0) {
                System.out.println(0);}
            else {
                calcCount(gap);
            }
        }
    }

    static void calcCount(int gap) {
        int[] dp = new int[gap + 1];
        for (int i = 1; i <= gap; i++) {dp[i] = 99999999;}
        dp[0] = 0;
        int[] arrayWeight = { 1, 2, 5, 10, 20, 50, 100 };

        for (int i = 0; i < 7; i++) {
            for (int j = arrayWeight[i]; j <= gap; j++) {
                int tmp = dp[j - arrayWeight[i]] + 1;
                if (dp[j] > tmp) {
                    dp[j] = tmp;
                }
            }
        }
        System.out.println(dp[gap]);
    }
}

// Greedy
//        int[] arrayWeight = {100, 50, 20, 10, 5, 2, 1};
//        for(int i = 0; i < 7; i++){
//            if(gap >= arrayWeight[i]){
//                cnt += gap / arrayWeight[i];
//                gap %= arrayWeight[i];
//            }
//        }
