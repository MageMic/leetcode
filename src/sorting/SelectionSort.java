package sorting;

public class SelectionSort {
    public static int[] selectionSort(int[] A, int n) {
        // write code here
        if (A == null || n == 0) {
            return A;
        }
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (A[j] < A[minIndex]) {
                   minIndex = j;
                }
            }
            int temp = A[minIndex];
            A[minIndex] = A[i];
            A[i] = temp;
        }
        return A;
    }

    public static void main(String[] args) {
        int[] A = {3, 2, 5, 8, 0};
        selectionSort(A, A.length);
        for (int a : A) {
            System.out.print(a + " ");
        }
    }
}
