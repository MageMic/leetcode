package IO;

import java.io.*;

/**
 * @Author: zjumic
 * @Date: created at 16:07 2020/2/26
 */
public class FileStreamOperation {

    public static void main(String[] args) {
        String fileName = "E:/java/leetcode/src/interview/file.txt";
        File file = new File(fileName);

        try ( FileOutputStream fos = new FileOutputStream(file);
              DataOutputStream dos = new DataOutputStream(fos);
              DataInputStream dis = new DataInputStream(new FileInputStream(file))) {

            file.createNewFile();
            for (int i = 0; i < 100; i++) {
                int num = (int)(Math.random() * 10000);
                dos.writeInt(num);
            }

            int min = 10000;
            int max = -1;
            int sum = 0;

            while (dis.available() > 0) {
                int num = dis.readInt();
                if (num < min) {
                    min = num;
                }
                if (num > max) {
                    max = num;
                }
                sum += num;
            }
            System.out.println("最大值: " + max);
            System.out.println("最小值: " + min);
            System.out.println("平均值: " + sum / 100);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
