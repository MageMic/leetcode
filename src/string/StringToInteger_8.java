package string;

// 8.字符串转换整数（atoi）
public class StringToInteger_8 {

    public int myAtoi(String str) {
        int i = 0, j = 0;
        boolean negative = false;
        for (;i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                break;
            }
            else if (str.charAt(i) == '-' || str.charAt(i) == '+') {
                negative = str.charAt(i) == '-';
                i++;
                break;
            } else {
                if (str.charAt(i) != ' ')
                    return 0;
            }
        }
        for (j = i; j < str.length(); j++) {
            if (str.charAt(j) < '0' || str.charAt(j) > '9') {
                break;
            }
        }

        int ret = 0;
        String num = str.substring(i, j);

        for (int x = 0; x < num.length(); x++) {
            int cur = num.charAt(x) - '0';
            if (negative) {
                if (ret < Integer.MIN_VALUE / 10 || ret == Integer.MIN_VALUE / 10 && cur > 8)
                    return Integer.MIN_VALUE;
                ret = ret * 10 - cur;
            } else {
                if (ret > Integer.MAX_VALUE / 10 || ret == Integer.MAX_VALUE / 10 && cur > 7) {
                    return Integer.MAX_VALUE;
                }
                ret = ret * 10 + cur;
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        StringToInteger_8 solution = new StringToInteger_8();

        System.out.println(solution.myAtoi("-42"));
        System.out.println(solution.myAtoi("4193 with words"));
        System.out.println(solution.myAtoi( "words and 987"));
    }
}
