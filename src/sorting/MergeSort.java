package sorting;

public class MergeSort {
    public static int[] mergeSort(int[] A, int n) {
        // write code here
        if(A == null || n < 2) {
            return A;
        }

        return merge(A, 0, n - 1);
    }

    private static int[] merge(int[] A, int l, int r) {
        if (l == r) {
            return new int[] {A[l]};
        }

        int mid = l + (r - l) / 2;

        int[] left = merge(A, l, mid);
        int[] right = merge(A, mid + 1, r);
        int[] ret = new int[left.length + right.length];

        int i = 0, j = 0, m = 0;
        while (i < left.length && j < right.length) {
            ret[m++] = left[i] < right[j] ? left[i++] : right[j++];
        }
        while (i < left.length) {
            ret[m++] = left[i++];
        }
        while (j < right.length) {
            ret[m++] = right[j++];
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] A = {3, 2, 5, 8, 0};
        A = mergeSort(A, A.length);
        for (int a : A) {
            System.out.print(a + " ");
        }
    }
}
