package p2000_;

import java.util.HashSet;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/find-the-longest-valid-obstacle-course-at-each-position/
 *
 * @author half-dead
 */
public class Puzzle1964 {

    // binary search
    class Solution {
        public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
            int n = obstacles.length, limit = 0;
            int[] res = new int[n], q = new int[n];
            for (int i = 0; i < n; i++) {
                int lo = 0, hi = limit, v = obstacles[i];
                while (lo < hi) {
                    int mid = (lo + hi) / 2;
                    if (q[mid] <= v) {
                        lo = mid + 1;
                    } else {
                        hi = mid;
                    }
                }
                res[i] = lo + 1;
                q[lo] = v;
                if (lo == limit) limit++;
            }
            return res;
        }
    }

    class Solution1 {
        public int[] longestObstacleCourseAtEachPosition(int[] obs) {
            int n = obs.length;
            int[] res = new int[n];
            TreeMap<Integer, Integer> tm = new TreeMap<>();
            tm.put(0, 0);
            for (int i = 0; i < n; i++) {
                int curr = tm.floorEntry(obs[i]).getValue() + 1;
                java.util.NavigableMap<Integer, Integer> tail = tm.tailMap(obs[i], true);
                Set<Integer> remove = new HashSet<>();
                for (int k : tail.keySet()) {
                    if (tail.get(k) <= curr) {
                        remove.add(k);
                    } else {
                        break;
                    }
                }
                for (int k : remove) tm.remove(k);
                tm.put(obs[i], res[i] = curr);
            }
            return res;
        }
    }
}
