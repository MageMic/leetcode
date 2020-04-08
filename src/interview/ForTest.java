package interview;

import java.util.Arrays;

public class ForTest {
    public static void main(String[] args) {
        test(3);
    }

    private static void test(int n) {
        char[][] a = new char[n][n];

        for (int i = 0; i < n; i++) {
            a[i][i] = 'a';
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j]);
            }
            System.out.println();
        }
    }
}
