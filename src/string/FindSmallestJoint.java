package string;

import java.util.Arrays;

public class FindSmallestJoint {
    public String findSmallest(String[] strs, int n) {
        // write code here
        if (n == 0) {
            return "";
        }
        Arrays.sort(strs, (a, b) -> (a + b).compareTo(b + a));
        StringBuffer sb = new StringBuffer();
        for (String str : strs) {
            sb.append(str);
        }
        // return sb.toString();
        return Arrays.stream(strs).sorted((x, y) -> (x + y).compareTo(y + x)).reduce("", (x, y) -> x + y);
    }
}
