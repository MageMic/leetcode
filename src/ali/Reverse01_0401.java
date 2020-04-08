package ali;

/**
 * @Author: zjumic
 * @Date: created at 17:24 2020/4/5
 */

// 一个只有01的串，每次可以同时翻转i-1,i,i+1位（左右端只翻转两位），求最小翻转次数（如无法反转，则输出”No"）
public class Reverse01_0401 {

    public static void main(String[] args) {
        String s = "101";
        int res = canReverse(s);
        StringBuffer sb = new StringBuffer(s);
        sb.setCharAt(0, '0');
        sb.setCharAt(1, ((char)('0' + ('1' - sb.charAt(1)))));
        int res2 = canReverse(sb.toString());
        if (res2 != -1 && res != -1) {
            res = Math.min(res, res2 + 1);
        } else if (res == -1 && res2 != -1) {
            res = res2 + 1;
        }
        if (res == -1) {
            System.out.println("NO");
        } else {
            System.out.println(res);
        }
    }

    public static int canReverse(String s) {
        char[] arr = s.toCharArray();
        int count = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == '1') {
                arr[i] = '0';
                arr[i + 1] = (char)('0' + ('1' - arr[i + 1]));
                if (i + 2 < arr.length) {
                    arr[i + 2] = (char)('0' + ('1' - arr[i + 2]));
                }
                count++;
            }
        }
        if (arr[arr.length - 1] == '1') {
            return -1;
        } else {
            return count;
        }
    }
}
