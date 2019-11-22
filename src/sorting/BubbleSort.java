package sorting;

public class BubbleSort {
    public static int[] bubbleSort(int[] A, int n) {
        if (A == null || n == 0) {
            return A;
        }
        for (int i = 0; i < n - 1; i++) {
            boolean isSorted = true;
            for (int j = 0; j < n - 1 - i; j++) {
                if (A[j] > A[j + 1]) {
                    int temp = A[j + 1];
                    A[j + 1] = A[j];
                    A[j] = temp;
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        int[] A = {3, 2, 5, 8, 0};
        bubbleSort(A, A.length);
        for (int a : A) {
            System.out.print(a + " ");
        }
    }
}
