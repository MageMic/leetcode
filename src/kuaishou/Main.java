package kuaishou;

// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        while (in.hasNextInt()) {
            list.add(in.nextInt());
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int cur = list.get(i);
            if (i > 0) {
                int count = 0;
                for (int num : map.keySet()) {
                    if (num > cur) {
                        count += map.get(num);
                        if (count > 1) break;
                    }
                }
                if (count == 1) {
                    result.add(i);
                }
            }
            if (!map.containsKey(cur)) {
                map.put(cur, 1);
            } else {
                map.put(cur, map.get(cur) + 1);
            }
        }
        if (result.isEmpty()) {
            System.out.println(-1);
        } else {
            for (int i : result) {
                System.out.print(i + " ");
            }
        }
    }
}