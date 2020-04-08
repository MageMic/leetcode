package interview;

/**
 * @Author: zjumic
 * @Date: created at 15:09 2020/4/2
 */
public class CloneTest implements Cloneable{

    String s1;
    CloneTest(String s1) {
        this.s1 = s1;
    }

    @Override
    protected CloneTest clone() throws CloneNotSupportedException {
        return (CloneTest)super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        String t1 = new String("abc");
        String t2 = "abc";

        CloneTest c1 = new CloneTest(t1);
        CloneTest clone1 = c1.clone();
        clone1.s1 = "av";
        System.out.println("cloneObject1:" + clone1.s1 + "; original1:" + c1.s1);

        CloneTest c2 = new CloneTest(t2);
        CloneTest clone2 = c2.clone();
        clone2.s1 = new String("avb");
        System.out.println("cloneObject2:" + clone2.s1 + "; original2:" + c2.s1);
    }
}
