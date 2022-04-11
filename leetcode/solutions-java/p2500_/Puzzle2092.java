package p2500_;

import java.util.*;

/**
 * https://leetcode.com/problems/find-all-people-with-secret/
 *
 * @author half-dead
 */
public class Puzzle2092 {

    class Solution {
        public List<Integer> findAllPeople(int n, int[][] meetings, int first) {
            boolean[] set = new boolean[100001];
            set[0] = set[first] = true;

            Arrays.sort(meetings, Comparator.comparingInt(a -> a[2]));

            Set<Integer> round = new HashSet<>();
            Map<Integer, Integer> dsu = new HashMap<>();
            int len = meetings.length, ptime = 0;
            for (int i = 0; i <= len; i++) {
                int time = i == len ? Integer.MAX_VALUE : meetings[i][2];

                if (time > ptime) {
                    settle(set, round, dsu);
                    if (i == len) break;

                    round = new HashSet<>();
                    dsu = new HashMap<>();
                    ptime = time;
                }
                int x = meetings[i][0], y = meetings[i][1];
                if (set[x] || set[y]) {
                    set[x] = set[y] = true;
                } else {
                    round.add(x);
                    round.add(y);
                    union(x, y, dsu);
                }

            }
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < set.length; i++) {
                if (set[i]) res.add(i);
            }
            return res;
        }

        void union(int x, int y, Map<Integer, Integer> dsu) {
            dsu.put(find(x, dsu), find(y, dsu));
        }

        int find(int x, Map<Integer, Integer> dsu) {
            int p = x;
            while (dsu.getOrDefault(p, p) != p) {
                p = dsu.getOrDefault(p, p);
            }
            dsu.put(x, p);
            return p;
        }

        void settle(boolean[] set, Set<Integer> round, Map<Integer, Integer> dsu) {
            Map<Integer, Set<Integer>> groups = new HashMap<>();
            for (int x : round) {
                int px = find(x, dsu);
                Set<Integer> g = groups.computeIfAbsent(px, t -> new HashSet<>());
                g.add(x);
                if (set[x]) {
                    g.add(-1);
                }
            }
            for (Set<Integer> g : groups.values()) {
                if (g.contains(-1)) {
                    g.remove(-1);
                    for (int x : g) set[x] = true;
                }
            }
        }
    }

}
