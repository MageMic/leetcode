package array;

/**
 * @Author: zjumic
 * @Date: created at 21:55 2020/2/29
 */
public class FindNumsAppearOnce {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int result = array[0];
        for (int i = 1; i < array.length; i++) {
            result ^= array[i];
        }
        int indexOf1 = getFirst1Index(result);
        for (int i = 0; i < array.length; i++) {
            if (isBit1(array[i], indexOf1)) {
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }
    }

    private int getFirst1Index(int num) {
        int index = 0;
        while ((num & 1) == 0 && index < 32) {
            num >>= 1;
            index++;
        }
        return index;
    }

    private boolean isBit1(int num, int index) {
        num = num >> index;
        return (num & 1) > 0;
    }
}
