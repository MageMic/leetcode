package interview;

import java.io.*;
import java.util.BitSet;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @Author: zjumic
 * @Date: created at 20:02 2020/2/25
 */

// 大文件内容排序
//用有限内存（比如256MB），处理一个大文件（比如4GB），该文件每行都只有一个全局不重复的乱序数字（正整数），排序好输出到一个新的文件。
//为了节约时间，定义大文件是：100w行，内存能处理1w行（排序+输出）
//第一步：按要求生成一个文件input.txt
//第二步：按题目要求处理该文件，最终输出成output.txt
//第三步：统计排序算法的耗时，通过并发编程，在确保结果争取的基础上，如何减少耗时。
public class FileSort {
    private static String outputPath = "E:/java/leetcode/src/interview/output.txt";
    private static String inputPath = "E:/java/leetcode/src/interview/input.txt";
    private static ConcurrentMap<Integer, Integer> countMap = new ConcurrentHashMap<>();
    public static int capacity = 10000000;

    public static void main(String[] args) {
        generate();

        BitMap bitMap = new BitMap(capacity);
        readInMap(inputPath, bitMap);
        CyclicBarrier cb = new CyclicBarrier(4);
        int threadLen = capacity / 4;

        for (int i = 0; i < 4; i++) {
            new SortThread(bitMap, i * threadLen, (i + 1) * threadLen, cb, i).start();
        }

//        read();
    }

    private static void read() {
        try {
            RandomAccessFile file = new RandomAccessFile(outputPath, "r");

            while (file.getFilePointer() < file.length()) {
                System.out.println(file.readInt());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void generate() {

        BitMap bitMap = new BitMap(capacity);
        String fileName = "E:/java/leetcode/src/interview/input.txt";

        try (FileWriter writer = new FileWriter(new File(fileName))) {
            for (int i = 0; i< capacity / 10; i++) {
                int rand = (int)(Math.random() * capacity);
                while (bitMap.exist(rand)) {
                    rand = (int)(Math.random() * capacity);
                }
                bitMap.set(rand);
                writer.write(Integer.toString(rand));
                writer.write("\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readInMap(String fileName, BitMap readMap) {
        try (FileReader reader = new FileReader(new File(fileName))) {
            BufferedReader bf = new BufferedReader(reader);
            String read;
            while ((read = bf.readLine()) != null) {
                readMap.set(Integer.parseInt(read));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class SortThread extends Thread {
        BitMap map;
        CyclicBarrier cyclicBarrier;
        int startIndex;
        int endIndex;
        int threadNum;

        SortThread(BitMap map, int startIndex, int endIndex, CyclicBarrier cyclicBarrier, int threadNum) {
            this.map = map;
            this.startIndex = startIndex;
            this.endIndex = endIndex;
            this.cyclicBarrier = cyclicBarrier;
            this.threadNum = threadNum;
        }

        @Override
        public void run() {

            int count = 0;
            for (int i = startIndex; i < endIndex; i++) {
                if (map.exist(i)) {
                    count++;
                }
            }
            countMap.put(threadNum, count * 4);
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            try {
                RandomAccessFile file = new RandomAccessFile(outputPath, "rw");
                int start = 0;
                for (int i = 0; i < threadNum; i++) {
                    start += countMap.get(i);
                }
                file.seek(start);
                for (int i = startIndex; i < endIndex; i++) {
                    if (map.exist(i)) {
                        file.writeInt(i);
                    }
                }
                file.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static class BitMap {
        int capacity;
        byte[] bitMap;

        BitMap(int capacity) {
            this.capacity = capacity;
            bitMap = new byte[capacity / 8 + 1];
        }

        int getIndex (int num) {
            return num / 8;
        }

        int getPosition(int num) {
            return num & 0x07;
        }

        void set(int num) {
            bitMap[getIndex(num)] |= 1 << getPosition(num);
        }

        boolean exist(int num) {
           return (bitMap[getIndex(num)] & (1 << getPosition(num))) != 0;
        }
    }


}
