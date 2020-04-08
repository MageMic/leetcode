package interview;
//package main
//注意不要添加包名称，否则会报错。

import java.io.*;
import java.util.*;

// 输出 模型文件k 用户类型1 用户类型2 v

// 4 3
//1 0 -1 1
//-2 0 -1 -3
//2 2 0 0
public class Main{
    private static int start, end;
    private static HashMap<Integer, Integer> gateMapIndex = new HashMap<>();
    private static HashMap<Integer, Integer> gateMapNum = new HashMap<>();
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int cols = cin.nextInt();
        int rows = cin.nextInt();
        int[] mg = new int[rows * cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                mg[i * cols + j] = cin.nextInt();
            }
        }
        findPoints(mg, rows, cols);
        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>();
        gateMapIndex.entrySet().stream().sorted((e1, e2) -> e2.getValue() - e1.getValue()).limit(2).forEach(entry -> list.add(entry));
        Set<Map.Entry<Integer, Integer>> set = gateMapIndex.entrySet();

        for (Map.Entry entry : list) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        gateMapIndex.keySet().forEach(integer -> System.out.println(integer + ": " + gateMapIndex.get(integer)));
        System.out.println(findPath(mg, start, end, cols, rows));
    }

    private static void findPoints(int[] mg, int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int index = i * cols + j;
                if (mg[index] == -2) {
                    start = index;
                }
                if (mg[index] == -3) {
                    end = index;
                }
                if (mg[index] > 0) {
                    if (!gateMapNum.containsKey(mg[index])) {
                        gateMapNum.put(mg[index], index);
                        gateMapIndex.put(index, 0);
                    } else {
                        int gateIndex1 = gateMapNum.get(mg[index]);
                        gateMapIndex.put(gateIndex1, index);
                        gateMapIndex.put(index, gateIndex1);
                    }
                }
            }
        }
    }

    private static int findPath(int[] mg, int start, int end, int cols, int rows) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] flag = new boolean[mg.length];
        flag[start] = true;
        queue.offer(start);
        int pathLength = -1;
        while (!queue.isEmpty()) {
            pathLength++;
            int size = queue.size();
            while (size-- > 0) {
                int cur = queue.poll();
                if (cur == end) {
                    return pathLength;
                }
                int col = cur % cols;
                int row = cur / cols;
                int newCol, newRow;
                int next;
                if ((newCol = col - 1) >= 0) {
                    int newIndex = row * cols + newCol;
                    if (gateMapIndex.containsKey(newIndex)) {
                        newIndex = gateMapIndex.get(newIndex);
                    }
                    if (!flag[newIndex] && mg[newIndex] != -1) {
                        flag[newIndex] = true;
                        queue.offer(newIndex);
                    }
                }
                if ((newCol = col + 1) < cols) {
                    int newIndex = row * cols + newCol;
                    if (gateMapIndex.containsKey(newIndex)) {
                        next = gateMapIndex.get(newIndex);
                    } else {
                        next = newIndex;
                    }
                    if (!flag[next] && mg[next] != -1) {
                        flag[next] = true;
                        queue.offer(next);
                    }
                }
                if ((newRow = row - 1) >= 0) {
                    int newIndex = newRow * cols + col;
                    if (gateMapIndex.containsKey(newIndex)) {
                        newIndex = gateMapIndex.get(newIndex);
                    }
                    if (!flag[newIndex] && mg[newIndex] != -1) {
                        flag[newIndex] = true;
                        queue.offer(newIndex);
                    }
                }
                if ((newRow = row + 1) < rows) {
                    int newIndex = newRow * cols + col;
                    if (gateMapIndex.containsKey(newIndex)) {
                        newIndex = gateMapIndex.get(newIndex);
                    }
                    if (!flag[newIndex] && mg[newIndex] != -1) {
                        flag[newIndex] = true;
                        queue.offer(newIndex);
                    }
                }
            }
        }
        return -1;
    }
}

//    public static void main(String args[]) {
//        Scanner cin = new Scanner(System.in);
//        int D = cin.nextInt();
//        int W = cin.nextInt();
//        ArrayList<Integer> list = new ArrayList<>();
//        while (cin.hasNextInt()) {
//            list.add(cin.nextInt());
//        }
//        int n = list.size() / 2;
//        int[] position = new int[n];
//        int[] supply = new int[n];
//        for (int i = 0; i < n; i++) {
//            position[i] = list.get(i);
//        }
//
//        for (int i = 0; i < n; i++) {
//            supply[i] = list.get(n + i);
//        }
//
//        System.out.println(supplyCount(D, W, position, supply));
//    }
//
//    public static int supplyCount(int D, int W, int[] position, int[] supply) {
//        int n = position.length;
//        long[] dp = new long[n + 1];
//        dp[0] = W;
//        for (int i =0; i < n; i++) {
//            for (int t = i; t >= 0; t--) {
//                if (dp[t] >= position[i]) {
//                    dp[t + 1] = Math.max(dp[t + 1], dp[t] + (long) supply[i]);
//                }
//            }
//        }
//        for (int i = 0; i <= n; i++) {
//            if (dp[i] >= D) {
//                return i;
//            }
//        }
//        return -1;
//    }

//    public static void main(String args[]) {
//        Scanner cin = new Scanner(System.in);
//        int N = cin.nextInt();
//        TreeMap<String, ArrayList<String>> map = new TreeMap<>();
//
//        for (int i = 0; i < N; i++) {
//            String userType = cin.next();
//            String modelFile = cin.next();
//            if (!map.containsKey(modelFile)) {
//                ArrayList<String> userList = new ArrayList<>();
//                userList.add(userType);
//                map.put(modelFile, userList);
//            } else {
//                ArrayList<String> userList = map.get(modelFile);
//                userList.add(userType);
//                userList.sort(Comparator.naturalOrder());
//                map.put(modelFile,userList);
//            }
//        }
//
//        print(map);
//    }
//
//    public static void print(TreeMap<String, ArrayList<String>> map) {
//        if (map.isEmpty()) {
//            return;
//        }
//        Set<String> keySet =  map.keySet();
//
//        for (String modelFile : keySet) {
//            StringBuffer sb = new StringBuffer();
//            sb.append(modelFile);
//            ArrayList<String> userList;
//            if (!(userList = map.get(modelFile)).isEmpty()) {
//                sb.append(" ");
//                for (int i = 0; i < userList.size(); i++) {
//                    sb.append(userList.get(i));
//                    if (i != userList.size() - 1) {
//                        sb.append(" ");
//                    }
//                }
//            }
//            System.out.println(sb.toString());
//        }
//    }