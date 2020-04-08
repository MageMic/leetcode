package string;

/**
 * @Author: zjumic
 * @Date: created at 14:08 2020/3/6
 */
public class IsNumeric {
    private int indexLocal = 0;

    public boolean isNumeric(char[] str) {
        if (str == null) {
            return false;
        }

        boolean numeric = false;
        numeric = scanInteger(str);

        if (indexLocal != str.length && str[indexLocal] == '.') {
            indexLocal++;
            numeric = scanUnsignedInteger(str) || numeric;
        }
        if (indexLocal != str.length && (str[indexLocal] == 'e' || str[indexLocal] == 'E')) {
            indexLocal++;
            numeric = scanInteger(str) && numeric;
        }

        return numeric && indexLocal == str.length;
    }

    private boolean scanInteger(char[] str) {
        if (indexLocal != str.length && (str[indexLocal] == '+' || str[indexLocal] == '-')) {
            indexLocal++;
        }
        return scanUnsignedInteger(str);
    }

    private boolean scanUnsignedInteger(char[] str) {
        int indexBefore = indexLocal;
        while (indexLocal != str.length && (str[indexLocal] > '0' && str[indexLocal] <'9')) {
            indexLocal++;
        }
        return indexLocal > indexBefore;
    }

    public static void main(String[] args) {
        IsNumeric i = new IsNumeric();
        System.out.println(i.isNumeric(".1".toCharArray()));
    }
}
