package other;

/**
 * @Author: zjumic
 * @Date: created at 16:33 2020/4/6
 */
// 1到n中1出现的次数
public class NumberOfOneBetween1AndN {

    public int solution(int n) {
        if (n <= 0) {
            return 0;
        }
        String num = Integer.toString(n);
        return numberOf1(num);
    }

    private int numberOf1(String num) {
        if (num == null || num.equals("")) {
            return 0;
        }
        int length = num.length();
        int first = num.charAt(0) - '0';
        if (length == 1 && first == 0) {
            return 0;
        }
        if (length == 1 && first > 0) {
            return 1;
        }
        int numFirstDigit = 0;
        // 第一位如果大于1，那么就有第一位为1时的后面跟着的10的n-1次方的数
        if (first > 1) {
            numFirstDigit = powerBase10(length - 1);
        } else if (first == 1){
            numFirstDigit = Integer.parseInt(num.substring(1)) + 1;
        }
        // 剩下其他位数，固定一位，剩下的位数可以从0-9自由组合，所以
        // 其他位1的个数等于最高位的数*位数-1*10的(位数-2)次方
        int numOtherDigits = first * (length - 1) * powerBase10(length - 2);
        int numRecursive = numberOf1(num.substring(1));
        return numFirstDigit + numOtherDigits + numRecursive;
    }

    private int powerBase10(int power) {
        int result = 1;
        for (int i = 1; i <= power; i++) {
            result *= 10;
        }
        return result;
    }
}
