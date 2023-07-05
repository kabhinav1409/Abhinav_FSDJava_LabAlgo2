package com.paymoney;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the size of the transaction array:");
        int size = scanner.nextInt();

        int[] transactions = new int[size];
        System.out.println("Enter the values of the array:");
        for (int i = 0; i < size; i++) {
            transactions[i] = scanner.nextInt();
        }

        System.out.println("Enter the total number of targets that need to be achieved:");
        int numTargets = scanner.nextInt();

        for (int i = 0; i < numTargets; i++) {
            System.out.println("Enter the value of the target:");
            int target = scanner.nextInt();

            int achievedTransactionIndex = getAchievedTransactionIndex(transactions, target);

            if (achievedTransactionIndex != -1) {
                System.out.println("Target achieved after " + achievedTransactionIndex + " transaction(s)");
            } else {
                System.out.println("Given target is not achieved");
            }
        }

        scanner.close();
    }

    public static int getAchievedTransactionIndex(int[] transactions, int target) {
        int sum = 0;
        for (int i = 0; i < transactions.length; i++) {
            sum += transactions[i];
            if (sum >= target) {
                return i + 1;
            }
        }
        return -1;
    }
}
