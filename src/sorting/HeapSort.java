package sorting;

public class HeapSort {

    public int[] heapSort(int[] A, int n) {
        // write code here
        // 堆化
        for (int i = n / 2; i >= 0; i--) {
            heapify(A, i, n);
        }
        // 排序，每次取最大的到队列尾，然后堆化--
        for (int i = n - 1; i >= 0; i--) {
            swap(A, 0, i);
            heapify(A, 0, i);
        }
        return A;
    }

    private void heapify(int[] A, int parent, int length) {
        int pValue = A[parent];
        int child = parent * 2 + 1;
        while (child < length) {
            if (child + 1 < length && A[child] < A[child + 1]) {
                child = child + 1;
            }
            if (pValue > A[child]) {
                break;
            }
            A[parent] = A[child];
            parent = child;
            child = parent * 2 + 1;
        }
        A[parent] = pValue;
    }

    private void swap(int[] A, int i, int j) {
        if (i != j) {
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
    }
}
