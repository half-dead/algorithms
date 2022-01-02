package p2000_;

import java.util.*;

/**
 * https://leetcode.com/problems/alert-using-same-key-card-three-or-more-times-in-a-one-hour-period/
 *
 * @author half-dead
 */
public class Puzzle1604 {

    public static void main(String[] args) {
        Solution s = new Puzzle1604().new Solution();
        System.out.println(s.alertNames(new String[]{
                "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "b", "b", "b", "b", "b", "b", "b", "c", "c", "c", "c", "c", "d", "d", "d", "d", "d", "d", "d", "d", "e", "e", "e", "e", "e", "e", "e", "e", "e", "e", "f", "f", "f", "f", "f", "f", "f", "g", "g", "g", "g", "g", "g", "g", "g", "g", "g",
                "h", "h", "h", "h", "h", "h"
        }, new String[]{
                "10:57", "12:51", "04:02", "21:30", "00:33", "02:57", "18:25", "05:13", "00:11", "13:15", "04:05", "19:55", "15:00", "05:47", "03:07", "14:20", "22:18", "01:27", "11:25", "00:32", "12:43", "12:07", "04:36", "09:53", "05:05", "09:59", "02:58", "23:02", "17:15", "14:04", "11:48", "17:31", "19:54", "15:29", "20:14", "09:33", "14:09", "06:18", "21:47", "22:07", "13:36", "12:40", "04:47", "12:33", "13:31", "19:27", "13:28", "23:11", "06:43", "11:30", "21:53", "02:00", "00:08", "23:09", "03:44", "11:50", "20:34",
                "00:00", "17:18", "02:08", "04:56", "16:57", "09:50"
        }));
    }

    class Solution {
        public List<String> alertNames(String[] keyName, String[] keyTime) {
            Set<String>[] sets = new Set[1440];
            for (int i = 0; i < 1440; i++) sets[i] = new HashSet<>();

            for (int i = 0; i < keyName.length; i++) {
                int idx = Integer.parseInt(keyTime[i].substring(0, 2)) * 60
                        + Integer.parseInt(keyTime[i].substring(3));
                sets[idx].add(keyName[i]);
            }

            Set<String> res = new TreeSet<>();
            Map<String, Integer> freq = new HashMap<>();
            for (int i = 0; i < 1440; i++) {
                if (i > 60) {
                    Set<String> remove = sets[i - 61];
                    for (String name : remove) {
                        if (!res.contains(name))
                            freq.put(name, freq.get(name) - 1);
                    }
                }

                Set<String> pile = sets[i];
                for (String name : pile) {
                    if (res.contains(name)) continue;

                    int prev = freq.getOrDefault(name, 0);
                    if (prev == 2) {
                        freq.remove(name);
                        res.add(name);
                    } else {
                        freq.put(name, prev + 1);
                    }
                }
            }
            return new ArrayList<>(res);
        }
    }
}
