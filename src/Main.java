import java.util.*;


/**
 * @Author: zjumic
 * @Date: created at 18:59 2020/3/19
 */
public class Main {
    private static class Student implements Comparable<Student> {
        int num;
        int score;
        Student(int num, int score) {
            this.num = num;
            this.score = score;
        }

        @Override
        public int compareTo(Student o) {
            if (o.score == this.score) {
                return this.num - o.num;
            } else {
                return this.score - o.score;
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<String> strList = new ArrayList<>();
        ArrayList<Integer> intList = new ArrayList<>();
        System.out.println(strList.getClass() == intList.getClass());
    }

}
