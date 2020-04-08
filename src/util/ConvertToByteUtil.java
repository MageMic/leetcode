package util;

import java.util.Arrays;

/**
 * @Author: zjumic
 * @Date: created at 12:36 2020/3/24
 */
public class ConvertToByteUtil {
    public static byte intToByte(int i) {
        return (byte)i;
    }
    public static int byteToInt(byte b) {
        return b & 0xff;
    }

    public static int byteArrayToInt(byte[] b) {
        return b[3] & 0xff |
                (b[2] & 0xff) << 8 |
                (b[1] & 0xff) << 16 |
                (b[0] & 0xff) << 24;
    }

    public static byte[] intToByteArray(int i) {
        return new byte[] {
                (byte)((i >> 24) & 0xff),
                (byte)((i >> 16) & 0xff),
                (byte)((i >> 8) & 0xff),
                (byte)((i) & 0xff)
        };
    }

    /**
     * 把字节数组转换成16进制字符串
     *
     * @param bArray
     * @return
     */
    public static final String bytesToHexString(byte[] bArray) {
        StringBuffer sb = new StringBuffer(bArray.length);
        String sTemp;
        for (int i = 0; i < bArray.length; i++) {
            sTemp = Integer.toHexString(0xFF & bArray[i]);
            if (sTemp.length() < 2)
                sb.append(0);
            sb.append(sTemp.toUpperCase());
        }
        return sb.toString();
    }

    public static final String byteToHex(byte b) {
        return bytesToHexString(new byte[]{b});
    }

    /**
     * 把16进制字符串转换成字节数组（自动把字符串转换为大写）
     *
     * @param hex
     * @return
     */
    public static byte[] hexStringToByte(String hex) {
        hex = hex.toUpperCase();
        int len = (hex.length() / 2);
        byte[] result = new byte[len];
        char[] achar = hex.toCharArray();
        for (int i = 0; i < len; i++) {
            int pos = i * 2;
            result[i] = (byte) (toByte(achar[pos]) << 4 | toByte(achar[pos + 1]));
        }
        return result;
    }

    private static byte toByte(char c) {
        byte b = (byte) "0123456789ABCDEF".indexOf(c);
        return b;
    }

    public static boolean isHexString(String str) {
        String regex="^[A-Fa-f0-9]+$";
        if (str.matches(regex)) {
            return true;
        } else {
            return false;
        }
    }

    public static String intTo36(int num) {
        char[] arr = new char[4];
        Arrays.fill(arr, '0');
        if (num < 36) {
            arr[3] = digitalToChar36(num);
        } else {
            int index = 3;
            while (num > 0) {
                int digital = num % 36;
                char ch = digitalToChar36(digital);
                arr[index--] = ch;
                num /= 36;
            }
        }
        return new String(arr);
    }

    private static char digitalToChar36(int num) {
        if (num >= 10) {
            return (char)('A' + (num - 10));
        } else {
            return (char)('0' + num);
        }
    }
}
