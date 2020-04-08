package other;

/**
 * @Author: zjumic
 * @Date: created at 20:40 2020/3/27
 */
public class SingleNumberK {
    // k个相同的k进制数无进位相加，其结果为0
    public int singleNumber(int[] nums, int k) {
        int[] eO = new int[32];
        for (int i = 0; i < nums.length; i++) {
            setExclusiveOr(eO, nums[i], k);
        }
        return getNumFromKSysNum(eO, k);
    }

    private void setExclusiveOr(int[] eO, int value, int k) {
        int[] curSys = getKSysNumFromNum(value, k);
        for (int i = 0; i < eO.length; i++) {
            eO[i] = (eO[i] + curSys[i]) % k; // 无进位相加
        }
    }

    // k进制的32位表示
    private int[] getKSysNumFromNum(int num, int k) {
        int[] res = new int[32];
        int index = 0;
        while (num != 0) {
            res[index++] = num % k;
            num /= k;
        }
        return res;
    }

    private int getNumFromKSysNum(int[] eO, int k) {
        int res = 0;
        for (int i = eO.length - 1; i >= 0; i--) {
            res = res * k + eO[i];
        }
        return res;
    }

    public static void main(String[] args) {
        SingleNumberK s = new SingleNumberK();
        int[] nums = new int[] {2,2,2,3,3,3,4,4,4,5};
        System.out.println(s.singleNumber(nums, 3));
    }
}
