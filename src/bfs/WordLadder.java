package bfs;

import java.util.*;

public class WordLadder {

    private class Pair<T> {
        private T key;
        private int val;
        Pair(T k, int v) {
            this.key = k;
            this.val = v;
        }
        T getKey() {
            return key;
        }
        int getVal() {
            return val;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, Boolean> record = new HashMap<>();
        record.put(beginWord, true);
        Queue<Pair<String>> queue = new LinkedList<>();
        queue.add(new Pair<>(beginWord, 1));
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Pair cur = queue.poll();
                String s = (String)cur.getKey();
                int step = cur.getVal();
                if (cur.getKey().equals(endWord)) {
                    return step;
                }
                for (String next : wordList) {
                    if (record.get(next) != null || !canTransfer(s, next)) {
                        continue;
                    }
                    record.put(next, true);
                    queue.add(new Pair<>(next, step + 1));
                }
            }
        }
        return 0;
    }
    private boolean canTransfer(String s, String t) {
        int index = 0;
        int cnt = 0;
        while (index < s.length()) {
            if (s.charAt(index) != t.charAt(index)) {
                cnt++;
                if (cnt > 1) {
                    break;
                }
            }
            index++;
        }
        return cnt == 1;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        System.out.println(new WordLadder().ladderLength(beginWord, endWord, wordList));
    }
}
