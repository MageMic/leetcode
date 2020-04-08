package string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @Author: zjumic
 * @Date: created at 17:47 2020/2/29
 */
public class PrintMinNumber {
    public String PrintMinNumber(int [] numbers) {
        StringBuffer sb = new StringBuffer();
        ArrayList<String> list = new ArrayList<>();
        if (numbers == null || numbers.length == 0) {
            return "";
        }
        for (int num : numbers) {
            list.add(Integer.toString(num));
        }
        String s = "ss";
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.parseInt(o1 + o2) - Integer.parseInt(o2 + o1);
            }
        });
        for (String num : list) {
            sb.append(num);
        }
        return sb.toString();
    }

}
