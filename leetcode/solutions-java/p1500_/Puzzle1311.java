package p1500_;

import java.util.*;

/**
 * https://leetcode.com/problems/get-watched-videos-by-your-friends/
 *
 * @author half-dead
 */
public class Puzzle1311 {

    class Solution {
        public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
            int len = friends.length, cl = 0;

            boolean[] seen = new boolean[len];
            seen[id] = true;
            LinkedList<Integer> q = new LinkedList<>();
            q.addLast(id);
            while (q.size() > 0 && cl < level) {
                int sz = q.size();
                while (sz-- > 0) {
                    int p = q.pollFirst();

                    for (int f : friends[p]) {
                        if (seen[f]) continue;
                        q.addLast(f);
                        seen[f] = true;
                    }
                }
                cl++;
            }

            Map<String, Integer> map = new HashMap<>();
            for (int p : q) {
                for (String vdo : watchedVideos.get(p)) {
                    map.put(vdo, map.getOrDefault(vdo, 0) + 1);
                }
            }

            List<String> res = new ArrayList<>(map.keySet());
            res.sort((a, b) -> {
                int d = map.get(a) - map.get(b);
                return d == 0 ? a.compareTo(b) : d;
            });
            return res;
        }
    }
}
