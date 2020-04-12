package string;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @Author: zjumic
 * @Date: created at 23:44 2020/4/8
 */
public class SortCharactersByFrequency {

    public static void main(String[] args) {
        String s = "tree";
        System.out.println(frequencySort(s));
    }

    public static String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }

        PriorityQueue<Character> pr = new PriorityQueue<>((c1, c2) -> map.get(c2) - map.get(c1));
        for (char key : map.keySet()) {
            pr.offer(key);
        }
        StringBuffer res = new StringBuffer();
        while (!pr.isEmpty()) {
            char cur = pr.poll();
            for (int i = 0; i < map.get(cur); i++) {
                res.append(cur);
            }
        }
        return res.toString();
    }
}
