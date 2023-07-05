package currencyDenomination;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of currency denominations: ");
        int size = scanner.nextInt();

        int[] denominations = new int[size];
        System.out.println("Enter the currency denominations value:");
        for (int i = 0; i < size; i++) {
            denominations[i] = scanner.nextInt();
        }

        System.out.print("Enter the amount you want to pay: ");
        int amount = scanner.nextInt();

        int[] paymentApproach = getMinimumNotes(denominations, amount);

        System.out.println("Your payment approach in order to give the minimum number of notes will be:");
        for (int i = 0; i < size; i++) {
            if (paymentApproach[i] != 0) {
                System.out.println(denominations[i] + ":" + paymentApproach[i]);
            }
        }

        scanner.close();
    }

    public static int[] getMinimumNotes(int[] denominations, int amount) {
        int size = denominations.length;
        int[] paymentApproach = new int[size];

        Arrays.sort(denominations); // Sort the denominations in ascending order

        for (int i = size - 1; i >= 0; i--) {
            if (amount >= denominations[i]) {
                paymentApproach[i] = amount / denominations[i];
                amount = amount % denominations[i];
            }
        }

        return paymentApproach;
    }
}
