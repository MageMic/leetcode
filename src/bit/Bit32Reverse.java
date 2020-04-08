package bit;

/**
 * @Author: zjumic
 * @Date: created at 0:05 2020/3/9
 */
public class Bit32Reverse {

    public int reverse(int num) {
        int mask;
        int ret = 0;
        int add = 0x80000000;

        for (int i = 0; i < 32; i++) {
            mask = (num & add);
            if (mask > 0) {
                mask = 1;
                for (int j = 0; j < i; j++) {
                    mask <<= 1;
                }
                ret |= mask;
            }
//            System.out.println("第" + i + "位：" + Integer.toHexString(mask));
            add >>>= 1;
//            System.out.println("add: " + add);
//            System.out.println("ret: " + Integer.toHexString(ret));
        }
        return ret;
    }

    public int reverse2(int num) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            ret <<= 1;
            ret |= num & 1;
            num >>= 1;
        }
        return ret;
    }

    public static void main(String[] args) {
        int num = 0x22221111;
//        System.out.println(Integer.toHexString(Integer.reverse(num)));
//        System.out.println(Integer.toHexString(Integer.reverseBytes(num)));

        Bit32Reverse reverse = new Bit32Reverse();
        System.out.println(Integer.toHexString(num));
        int res = reverse.reverse2(num);
        System.out.println(Integer.toHexString(res));
    }
}
