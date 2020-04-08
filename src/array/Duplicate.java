package array;

/**
 * @Author: zjumic
 * @Date: created at 14:03 2020/3/5
 */
public class Duplicate {

    public boolean duplicate(int numbers[],int length,int [] duplication) {
        int i = 0;

        while (i < length) {
            int m = numbers[i];
            if (m == i) {
                i++;
            } else if (numbers[m] == numbers[i]) {
                duplication[0] = numbers[i];
                return true;
            } else {
                numbers[i] = numbers[m];
                numbers[m] = m;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        Duplicate d = new Duplicate();
        int[] numbers = new int[] {2,3,1,0,2,5,3};
        int[] dup = new int[1];
        d.duplicate(numbers, numbers.length, dup);
        System.out.println(dup[0]);
    }
}
