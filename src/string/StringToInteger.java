package string;

/**
 * @Author: zjumic
 * @Date: created at 17:54 2020/3/21
 */
public class StringToInteger {

    // 如果返回0且flag为false表示输入错误
    private static boolean flag = true;
    public static int strToInt(String str) {
        if (str == null || str.length() == 0 || str.trim().equals("")) {
            flag = false;
            return 0;
        }
        boolean symbol = true;
        char[] chArr = str.toCharArray();
        int start = 0;
        if (chArr[0] == '-') {
            symbol = false;
            start = 1;
        } else {
            if (chArr[0] == '+') {
                start = 1;
            }
        }
        long result = 0;
        for (int i = start; i < chArr.length; i++) {
            if (chArr[i] < '0' || chArr[i] > '9') {
                flag = false;
                return 0;
            }
            result = result * 10 + (chArr[i] - '0');
            if (symbol && result > 0x7fffffff || !symbol && result < 0x80000000) {
                flag = false;
                return 0;
            }
        }
        return symbol ? (int)result : (int)result * (-1);
    }
}
