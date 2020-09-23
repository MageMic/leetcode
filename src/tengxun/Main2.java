package tengxun;

import java.util.*;

/**
 * @Author: zjumic
 * @Date: created at 20:29 2020/9/6
 */
public class Main2 {

    static HashMap<Integer, List<Integer>> teamMap = new HashMap<>();
    static List<List<Integer>> teamList = new ArrayList<>();
    static Set<Integer> noticeSet = new HashSet<>();

    static boolean[] visited;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        visited = new boolean[n];
        int m = in.nextInt();

        int member0Team = -1;

        for (int i = 0; i < m; i++) {
            int size = in.nextInt();
            List<Integer> curTeam = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                int cur = in.nextInt();
                if (teamMap.get(cur) == null) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    teamMap.put(cur, list);
                } else {
                    List<Integer> list = teamMap.get(cur);
                    list.add(i);
                }
                if (cur == 0) {
                    member0Team = i;
                }
                curTeam.add(cur);
            }
            teamList.add(curTeam);
        }

        checkVisited(teamList.get(member0Team));
        Set<Integer> memberSet = new HashSet<>();
        for (int resTeam : noticeSet) {
            List<Integer> team = teamList.get(resTeam);
            memberSet.addAll(team);
        }
        System.out.println(memberSet.size());

    }

    private static boolean checkVisited(List<Integer> begin) {
        List<Integer> next = new ArrayList<>();
        for (int member : begin) {
            if (!visited[member]) {
                List<Integer> team = teamMap.get(member);
                if (team != null) {
                    noticeSet.addAll(team);
                    next.addAll(team);
                }
                visited[member] = true;
            }
        }
        if (!next.isEmpty()) {
            return checkVisited(next);
        }
        return true;
    }
}
