package IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @Author: zjumic
 * @Date: created at 19:42 2020/3/13
 */

// 多线程copy大文件
public class ThreadCopyDemo {

    public static void main(String[] args) {
        String srcPath = "E:/java/leetcode/src/io/iosrc.txt";
        String desPath = "E:/java/leetcode/src/io/iosdes.txt";
        multipleThreadCopy(srcPath, desPath, 4);
        System.out.println("主线程结束...");
    }

    public static void multipleThreadCopy(String srcPath, String desPath, int threadNum) {
        if (threadNum < 1) {
            return;
        }

        File file = new File(srcPath);
        long length = file.length();
        long threadLen = length / threadNum; // 每个线程处理的长度

        long index = 0;
        for (int i = 0; i < threadNum - 1; i++) {
            if (index + threadLen < length) {
                System.out.println("第" + i + "个线程开始");
                new CopyThread(srcPath, desPath, index, index + threadLen).start();
                index += threadLen;
                System.out.println("第" + i + "个线程结束");
            } else {
                System.out.println("最后一个线程开始");
                new CopyThread(srcPath, desPath, index, length);
                System.out.println("最后一个线程结束");
            }
        }
    }

    private static class CopyThread extends Thread {
        String srcPath;
        String desPath;
        long startIndex;
        long endIndex;

        CopyThread(String srcPath, String desPath, long startIndex, long endIndex) {
            this.srcPath = srcPath;
            this.desPath = desPath;
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }

        @Override
        public void run() {
            try {
                RandomAccessFile src = new RandomAccessFile(srcPath, "r");
                RandomAccessFile des = new RandomAccessFile(desPath, "rw");
                src.seek(startIndex);
                des.seek(startIndex);

                long index = startIndex;
                byte[] bytes = new byte[1000];
                int n;
                while ((n = src.read(bytes)) != -1) {
                    des.write(bytes, 0, n);
                    index += n;
                    if (index > endIndex - 1) {
                        break;
                    }
                }
                src.close();
                des.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
