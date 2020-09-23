package array;

/**
 * @Author: zjumic
 * @Date: created at 21:17 2020/2/29
 */
// 逆序对的个数
public class InversePairs {

    public int InversePairs(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int[] copy = new int[array.length];

        int count = inversePairs(array, copy, 0, array.length - 1) ;

        return count;
    }

    public int inversePairs(int[] array, int[] copy, int start, int end) {
        if (start == end) {
            copy[start] = array[start];
            return 0;
        }

        int mid =  (end + start) / 2;

        int left = inversePairs(array, copy, start, mid);
        int right = inversePairs(array, copy, mid + 1, end);
        int count = left + right;
        // 前半段最后一个数字的下标
        int i = start;
        // 后半段最后一个数字的下标
        int j = mid + 1;
        // 辅助数组的最后一个下标
        int indexCopy = start;

        while (i <= mid && j <= end) {
            if (array[i] <= array[j]) {
                copy[indexCopy++] = array[i++];
            } else {
                count += (mid - i + 1);
                copy[indexCopy++] = array[j++];
            }
        }
        while (i > mid && j <= end) {
            copy[indexCopy++] = array[j++];
        }
        while (j > end && i <= mid) {
            copy[indexCopy++] = array[i++];
        }
        for(int s = start; s <= end; s++)
        {
            array[s] = copy[s];
        }
        return count;
    }

    public static void main(String[] args) {
        InversePairs ip = new InversePairs();
        int[] array = new int[] {1,2,3,4,5,6,7,0};
        System.out.println(ip.InversePairs(array));
    }
}
