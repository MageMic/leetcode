package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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

    public static void main(String[] args) {
//        int[] A = {3, 2, 8, 5, 0};
//        HeapSort h = new HeapSort();
//        h.heapSort(A, A.length);
//
//
//        Arrays.sort(A);
//
//        String[] sa = new String[] {"a", "ab", "abcd", "acd"};
//        Arrays.sort(sa, (s1, s2) -> s2.length() - s1.length());
//
//        for (String s : sa) {
//            System.out.print(s + " ");
//        }
//
//        for (int a : A) {
//            System.out.print(a + " ");
//        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(3);
        list.add(5);
        List<Integer> l = list.stream().filter(o1 -> o1 > 2).collect(Collectors.toList());
        for (int i : l) {
            System.out.println(i);
        }

        l = list.stream().filter(o1 -> o1 > 2).collect(Collectors.toList());
        for (int i : l) {
            System.out.println(i);
        }


        list.stream();
    }
}
