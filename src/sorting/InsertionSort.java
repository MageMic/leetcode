package sorting;

public class InsertionSort {

    public static int[] insertionSort(int[] A, int n) {
        // write code here
        if (A == null || n < 2) {
            return A;
        }
        for (int i = 1; i < n; i++) {
            for (int j = i; j >= 1; j--) {
                if (A[j] < A[j - 1]) {
                    int temp = A[j];
                    A[j] = A[j - 1];
                    A[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
        return A;
    }
    public static void main(String[] args) {
        int[] A = {3, 2, 5, 8, 0};
        insertionSort(A, A.length);
        for (int a : A) {
            System.out.print(a + " ");
        }
    }
}
