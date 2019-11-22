package sorting;

import java.util.Random;

public class QuickSort {
    public int[] quickSort(int[] A, int n) {
        // write code here
        if (A == null || n < 2) {
            return A;
        }
        quickSort(A, 0, n - 1);

        return A;
    }

    private void quickSort(int[] A, int start, int end) {
        if (start == end) {
            return;
        }
        int index = partition(A, start, end);
        if (index > start) {
            quickSort(A, start, index - 1);
        }
        if (index < end) {
            quickSort(A, index + 1, end);
        }
    }

    private int partition(int[] A, int start, int end) {
        Random random = new Random();
        int index = 0;
        if (start != end) {
            index = random.nextInt(end - start) + start;
        }
        swap(A, index, end);
        int small = start - 1;
        for (index = start; index < end; index++) {
            if (A[index] < A[end]) {
                small++;
                if (small != index) {
                    swap(A, small, index);
                }
            }
        }
        small++;
        swap(A, small, end);
        return small;
    }

    private void swap(int[] A, int i, int j) {
        if (i != j) {
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] A = {3, 2, 5, 8, 0};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(A, A.length);
        for (int a : A) {
            System.out.print(a + " ");
        }
    }
}
