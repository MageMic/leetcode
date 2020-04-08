package IO;

import java.io.*;

/**
 * @Author: zjumic
 * @Date: created at 16:36 2020/2/26
 */
public class FileOperation {
    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "E:/java/leetcode/src/interview/readerFile.txt";
        File file = new File(fileName);

        RandomAccessFile raf = new RandomAccessFile(fileName, "rw");

        try (FileWriter fw = new FileWriter(file);
             FileReader fr = new FileReader(file)
            ) {
            for (int i = 0; i < 10; i++) {
                int num = (int)(Math.random() * 10000);
                fw.write(Integer.toString(num));
                fw.write("\n");
            }
            int min = 10000;
            int max = -1;
            int sum = 0;
            fw.close();
            BufferedReader br = new BufferedReader(fr);
            String s = null;
            while ((s = br.readLine()) != null) {
                int num = Integer.parseInt(s);
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
            System.out.println("平均值: " + sum / 10);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
