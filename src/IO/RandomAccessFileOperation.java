package IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @Author: zjumic
 * @Date: created at 17:35 2020/2/26
 */
public class RandomAccessFileOperation {

    public static void main(String[] args) throws IOException {
        String fileName = "E:/java/leetcode/src/interview/randomAccessFile.txt";
        File f = new File(fileName);
        f.delete();
        RandomAccessFile ras = new RandomAccessFile(fileName, "rw");
        try {

            for (int i = 0; i < 2; i++) {
                int num = (int)(Math.random() * 10000);
                byte[] bs = Integer.toString(num).getBytes();
                ras.write(bs);
                ras.write("\n".getBytes());
                // ras.writeInt(num);
            }
            ras.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ras = new RandomAccessFile(fileName, "r");
        int min = 10000;
        int max = -1;
        int sum = 0;
        try {
            long length = ras.length();
            long filePointer = ras.getFilePointer();
            while (filePointer < length) {
//                int num = ras.readInt();
                int num = Integer.parseInt(ras.readLine());
                if (num < min) {
                    min = num;
                }
                if (num > max) {
                    max = num;
                }
                sum += num;
                filePointer = ras.getFilePointer();
            }
            System.out.println("最大值: " + max);
            System.out.println("最小值: " + min);
            System.out.println("平均值: " + sum / 100);
//            String s = null;
//            while ((s = ras.readLine()) != null) {
//                int num = Integer.parseInt(s);
//                if (num < min) {
//                    min = num;
//                }
//                if (num > max) {
//                    max = num;
//                }
//                sum += num;
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
