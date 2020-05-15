package Practice;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
          }
            int sign = 0;
            for (int m : arr) {
                sign = (sign ^ m);
            }
            sign = ((~sign + 1) & sign);
            int[] result = new int[2];
            for (int m : arr) {
                if ((sign & m) == sign) {
                    result[0] = result[0] ^ m;
                } else {
                    result[1] = result[1] ^ m;
                }
            }
            if (result[0] < result[1]) {
                System.out.printf("%d %d%n", result[0], result[1]);
            } else {
                System.out.printf("%d %d%n", result[1], result[0]);
            }
    }
}