package practice.zijie;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author: zjumic
 * @Date: created at 18:53 2020/4/13
 */
// 链接：https://www.nowcoder.com/questionTerminal/5afcf93c419a4aa793e9b325d01957e2?orderByHotValue=1&questionTypes=000100&mutiTagIds=665&page=1&onlyReference=false
//来源：牛客网
//
//第一行包含一个正整数N，代表测试用例的个数。
//
//每个测试用例的第一行包含一个正整数M，代表视频的帧数。
//
//接下来的M行，每行代表一帧。其中，第一个数字是该帧的特征个数，接下来的数字是在特征的取值；比如样例输入第三行里，2代表该帧有两个猫咪特征，<1，1>和<2，2>
//所有用例的输入特征总数和<100000
//
//N满足1≤N≤100000，M满足1≤M≤10000，一帧的特征个数满足 ≤ 10000。
//特征取值均为非负整数。
//
//
//输出描述:
//对每一个测试用例，输出特征运动的长度作为一行
//示例1
//输入
//1
//8
//2 1 1 2 2
//2 1 1 1 4
//2 1 1 2 2
//2 2 2 1 4
//0
//0
//1 1 1
//1 1 1
//输出
//3
//说明
//特征<1,1>在连续的帧中连续出现3次，相比其他特征连续出现的次数大，所以输出3
public class TezhengTiqu {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int m = sc.nextInt();
            HashMap<Pair<Integer, Integer>, Integer> indexMap = new HashMap<>();
            HashMap<Pair<Integer, Integer>, Integer> timesMap = new HashMap<>();
            int max = 0;
            for (int i = 0; i < m; i++) {
                int moves = sc.nextInt();
                while (moves-- > 0) {
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    Pair<Integer, Integer> pair = new Pair<>(x, y);
                    if (indexMap.get(pair) != null) {
                        if (indexMap.get(pair) == i - 1) {
                            int time = timesMap.get(pair) == null ? 1 : timesMap.get(pair) + 1;
                            max = Math.max(time, max);
                            timesMap.put(pair, time);
                        } else {
                            timesMap.put(pair, 1);
                        }
                    } else {
                        timesMap.put(pair, 1);
                    }
                    indexMap.put(pair, i);
                }
            }
            System.out.println(max);
        }
    }
}
