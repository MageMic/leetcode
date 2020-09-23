package practice.zijie;

import java.util.Scanner;

/**
 * @Author: zjumic
 * @Date: created at 13:12 2020/4/13
 */

// 链接：https://www.nowcoder.com/questionTerminal/42852fd7045c442192fa89404ab42e92?orderByHotValue=1&questionTypes=000100&mutiTagIds=665&page=1&onlyReference=false
//来源：牛客网
//
//1. 三个同样的字母连在一起，一定是拼写错误，去掉一个的就好啦：比如 helllo -> hello
//2. 两对一样的字母（AABB型）连在一起，一定是拼写错误，去掉第二对的一个字母就好啦：比如 helloo -> hello
//3. 上面的规则优先“从左到右”匹配，即如果是AABBCC，虽然AABB和BBCC都是错误拼写，应该优先考虑修复AABB，结果为AABCC
//输入描述:
//第一行包括一个数字N，表示本次用例包括多少个待校验的字符串。
//
//后面跟随N行，每行为一个待校验的字符串。
//
//
//输出描述:
//N行，每行包括一个被修复后的字符串。
//示例1
//输入
//2
//helloo
//wooooooow
//输出
//hello
//woow
public class ZifuxiugaiZidongji {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.println(deal(sc.nextLine()));
        }
        sc.close();
    }

    private static String deal(String s) {
        char cur;
        char last = s.charAt(0);
        int state = 0; // 初始状态为0
        StringBuffer sb = new StringBuffer();
        sb.append(last);
        for (int i = 1; i < s.length(); i++) {
            cur = s.charAt(i);
            switch (state) {
                case 0 :
                    if (cur == last) {
                        state = 1;
                    } else {
                        state = 0;
                    }
                    break;
                case 1 : // AA的形式
                    if (cur == last) continue; // AAA 忽略,直接跳过，不添加最后一个A
                    else state = 2; // 进入状态2 AAB
                    break;
                case 2 : // AAB
                {
                    if (cur == last) continue; // AABB 忽略，直接跳过，不添加最后一个B
                    else state = 0; // AABC
                    break;
                }
                default :
                    break;
            }
            sb.append(cur);
            last = cur;
        }
        return sb.toString();
    }
}
